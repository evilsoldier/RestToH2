package com.rest.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility methods for marshalling/unmarshalling messages from/to specific type.
 *
 * @author Evgeni Stoykov
 */
public final class JaxbUtils {

    private static final Map<Class, JAXBContext> jaxbCache = new HashMap<>();

    private JaxbUtils() {
    }

    /**
     * Marshall message to string type.
     *
     * @param object - the object content
     * @param clazz  - the class on the object to be marshalled
     * @return - marshalled content
     *
     * @throws JAXBException - if marshalling fails
     */
    public static String asString(Object object, Class<?> clazz) throws JAXBException {
        Marshaller marshaller = getInstance(clazz).createMarshaller();

        StringWriter writer = new StringWriter();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    /**
     * Unmarshall message to specified instance
     *
     * @param content - the message content as {@link String}
     * @param clazz   - The Class to be unmarshall the content
     * @param <T>     - return type. Same as clazz
     * @return Unmarshalled content from <T> type
     *
     * @throws JAXBException - if unmarshalling fails.
     */
    public static <T> T asObject(String content, Class<T> clazz) throws JAXBException {
        Unmarshaller unmarshaller = getInstance(clazz).createUnmarshaller();

        try (StringReader reader = new StringReader(content)) {
            return (T) unmarshaller.unmarshal(reader);
        }
    }

    private static JAXBContext getInstance(Class<?> clazz) throws JAXBException {
        synchronized (JaxbUtils.class) {
            if (!jaxbCache.containsKey(clazz)) {
                jaxbCache.put(clazz, JAXBContext.newInstance(clazz));
            }
        }

        return jaxbCache.get(clazz);
    }
}

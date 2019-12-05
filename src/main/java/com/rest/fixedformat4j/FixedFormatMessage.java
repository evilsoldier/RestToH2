package com.rest.fixedformat4j;

import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

/**
 * @author Georgi Trendafilov
 */
@Record
public class FixedFormatMessage {

    //S001-RMS-TBL-NAME(0,30)
    private String rmsTblName;

    //IS001-CRE-TMST(30,40)
    private String creTimst;

    //IS001-ACTN-TYP-CDE(40,41)
    private String actnTypCde;

    //IS001-MDSE-ADJ-ID(41,51)
    private String mdseAdjId;

    //IS001-ADJ-TYP-CDE(51,53)
    private String adjTypCde;

    //IS001-FR-SKU-NBR(53,61)
    private String frSkuNbr;

    //IS001-TO-SKU-NBR(61,69)
    private String toSkuNbr;

    //IS001-STR-NBR(69,73)
    private String strNbr;

    //IS001-WHSE-NBR(73,77)
    private String whseNbr;

    //IS001-ADJ-ACTN-CDE(77,78)
    private String adjActnCde;

    //IS001-OH-UNT-ADJ-QTY(78,88)
    private String ohUntAdjQty;

    //IS001-IN-TRNST-UNT-ADJ-QTY(88,98)
    private String inTrnstUntAdjQty;

    //IS001-FR-ITM-NBR(98,113)
    private String frItmNbr;

    //IS001-FR-DEPT-NBR(113,117)
    private String frDeptNbr;

    //IS001-FR-MAJ-CL-NBR(117,121)
    private String frMajClNbr;

    //IS001-FR-SUB-CL-NBR(121,125)
    private String frSubClNbr;

    //IS001-TO-ITM-NBR(125,140)
    private String toItmNbr;

    //IS001-TO-DEPT-NBR(140,144)
    private String toDeptNbr;

    //IS001-TO-MAJ-CL-NBR(144,148)
    private String toMajClNbr;

    //IS001-TO-SUB-CL-NBR(148,152)
    private String toSubClNbr;

    //IS001-FR-INTR-UPC-ID(152,162)
    private String frIntrUpcId;

    //IS001-TO-INTR-UPC-ID(162,172)
    private String toIntrUpcId;

    //IS001-PO-NBR(172,182)
    private String poNbr;

    //IS001-RCVR-SEQ-NBR(182,192)
    private String rcvrSeqNbr;

    //FILLER(192,500)
    private String filter;

    //IS001-RMS-TBL-NAME(0,30)
    @Field(offset = 1, length = 30)
    public String getRmsTblName() {
        return rmsTblName;
    }

    public void setRmsTblName(String rmsTblName) {
        this.rmsTblName = rmsTblName;
    }

    //IS001-CRE-TMST(30,40)
    @Field(offset = 31, length = 10)
    public String getCreTimst() {
        return creTimst;
    }

    public void setCreTimst(String creTimst) {
        this.creTimst = creTimst;
    }

    //IS001-ACTN-TYP-CDE(40,41)
    @Field(offset = 41, length = 1)
    public String getActnTypCde() {
        return actnTypCde;
    }

    public void setActnTypCde(String actnTypCde) {
        this.actnTypCde = actnTypCde;
    }

    //IS001-MDSE-ADJ-ID(41,51)
    @Field(offset = 42, length = 10)
    public String getMdseAdjId() {
        return mdseAdjId;
    }

    public void setMdseAdjId(String mdseAdjId) {
        this.mdseAdjId = mdseAdjId;
    }

    //IS001-ADJ-TYP-CDE(51,53)
    @Field(offset = 52, length = 2)
    public String getAdjTypCde() {
        return adjTypCde;
    }

    public void setAdjTypCde(String adjTypCde) {
        this.adjTypCde = adjTypCde;
    }

    //IS001-FR-SKU-NBR(53,61)
    @Field(offset = 54, length = 8)
    public String getFrSkuNbr() {
        return frSkuNbr;
    }

    public void setFrSkuNbr(String frSkuNbr) {
        this.frSkuNbr = frSkuNbr;
    }

    //IS001-TO-SKU-NBR(61,69)
    @Field(offset = 62, length = 8)
    public String getToSkuNbr() {
        return toSkuNbr;
    }

    public void setToSkuNbr(String toSkuNbr) {
        this.toSkuNbr = toSkuNbr;
    }

    //IS001-STR-NBR(69,73)
    @Field(offset = 70, length = 4)
    public String getStrNbr() {
        return strNbr;
    }

    public void setStrNbr(String strNbr) {
        this.strNbr = strNbr;
    }

    //IS001-WHSE-NBR(73,77)
    @Field(offset = 74, length = 4)
    public String getWhseNbr() {
        return whseNbr;
    }

    public void setWhseNbr(String whseNbr) {
        this.whseNbr = whseNbr;
    }

    //IS001-ADJ-ACTN-CDE(77,78)
    @Field(offset = 78, length = 1)
    public String getAdjActnCde() {
        return adjActnCde;
    }

    public void setAdjActnCde(String adjActnCde) {
        this.adjActnCde = adjActnCde;
    }

    //IS001-OH-UNT-ADJ-QTY(78,88)
    @Field(offset = 79, length = 10)
    public String getOhUntAdjQty() {
        return ohUntAdjQty;
    }

    public void setOhUntAdjQty(String ohUntAdjQty) {
        this.ohUntAdjQty = ohUntAdjQty;
    }

    //IS001-IN-TRNST-UNT-ADJ-QTY(88,98)
    @Field(offset = 89, length = 10)
    public String getInTrnstUntAdjQty() {
        return inTrnstUntAdjQty;
    }

    public void setInTrnstUntAdjQty(String inTrnstUntAdjQty) {
        this.inTrnstUntAdjQty = inTrnstUntAdjQty;
    }

    //IS001-FR-ITM-NBR(98,113)
    @Field(offset = 99, length = 15)
    public String getFrItmNbr() {
        return frItmNbr;
    }

    public void setFrItmNbr(String frItmNbr) {
        this.frItmNbr = frItmNbr;
    }

    //IS001-FR-DEPT-NBR(113,117)
    @Field(offset = 114, length = 4)
    public String getFrDeptNbr() {
        return frDeptNbr;
    }

    public void setFrDeptNbr(String frDeptNbr) {
        this.frDeptNbr = frDeptNbr;
    }

    //IS001-FR-MAJ-CL-NBR(117,121)
    @Field(offset = 118, length = 4)
    public String getFrMajClNbr() {
        return frMajClNbr;
    }

    public void setFrMajClNbr(String frMajClNbr) {
        this.frMajClNbr = frMajClNbr;
    }

    //IS001-FR-SUB-CL-NBR(121,125)
    @Field(offset = 122, length = 4)
    public String getFrSubClNbr() {
        return frSubClNbr;
    }

    public void setFrSubClNbr(String frSubClNbr) {
        this.frSubClNbr = frSubClNbr;
    }

    //IS001-TO-ITM-NBR(125,140)
    @Field(offset = 126, length = 15)
    public String getToItmNbr() {
        return toItmNbr;
    }

    public void setToItmNbr(String toItmNbr) {
        this.toItmNbr = toItmNbr;
    }

    //IS001-TO-DEPT-NBR(140,144)
    @Field(offset = 141, length = 4)
    public String getToDeptNbr() {
        return toDeptNbr;
    }

    public void setToDeptNbr(String toDeptNbr) {
        this.toDeptNbr = toDeptNbr;
    }

    //IS001-TO-MAJ-CL-NBR(144,148)
    @Field(offset = 145, length = 4)
    public String getToMajClNbr() {
        return toMajClNbr;
    }

    public void setToMajClNbr(String toMajClNbr) {
        this.toMajClNbr = toMajClNbr;
    }

    //IS001-TO-SUB-CL-NBR(148,152)
    @Field(offset = 149, length = 4)
    public String getToSubClNbr() {
        return toSubClNbr;
    }

    public void setToSubClNbr(String toSubClNbr) {
        this.toSubClNbr = toSubClNbr;
    }

    //IS001-FR-INTR-UPC-ID(152,162)
    @Field(offset = 153, length = 10)
    public String getFrIntrUpcId() {
        return frIntrUpcId;
    }

    public void setFrIntrUpcId(String frIntrUpcId) {
        this.frIntrUpcId = frIntrUpcId;
    }

    //IS001-TO-INTR-UPC-ID(162,172)
    @Field(offset = 163, length = 10)
    public String getToIntrUpcId() {
        return toIntrUpcId;
    }

    public void setToIntrUpcId(String toIntrUpcId) {
        this.toIntrUpcId = toIntrUpcId;
    }

    //IS001-PO-NBR(172,182)
    @Field(offset = 173, length = 10)
    public String getPoNbr() {
        return poNbr;
    }

    public void setPoNbr(String poNbr) {
        this.poNbr = poNbr;
    }

    //IS001-RCVR-SEQ-NBR(182,192)
    @Field(offset = 183, length = 10)
    public String getRcvrSeqNbr() {
        return rcvrSeqNbr;
    }

    public void setRcvrSeqNbr(String rcvrSeqNbr) {
        this.rcvrSeqNbr = rcvrSeqNbr;
    }

    //FILLER(192,500)
    @Field(offset = 193, length = 307)
    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "FixedFormatMessage{" +
                "rmsTblName='" + rmsTblName + '\'' +
                ", creTimst='" + creTimst + '\'' +
                ", actnTypCde='" + actnTypCde + '\'' +
                ", mdseAdjId='" + mdseAdjId + '\'' +
                ", adjTypCde='" + adjTypCde + '\'' +
                ", frSkuNbr='" + frSkuNbr + '\'' +
                ", toSkuNbr='" + toSkuNbr + '\'' +
                ", strNbr='" + strNbr + '\'' +
                ", whseNbr='" + whseNbr + '\'' +
                ", adjActnCde='" + adjActnCde + '\'' +
                ", ohUntAdjQty='" + ohUntAdjQty + '\'' +
                ", inTrnstUntAdjQty='" + inTrnstUntAdjQty + '\'' +
                ", frItmNbr='" + frItmNbr + '\'' +
                ", frDeptNbr='" + frDeptNbr + '\'' +
                ", frMajClNbr='" + frMajClNbr + '\'' +
                ", frSubClNbr='" + frSubClNbr + '\'' +
                ", toItmNbr='" + toItmNbr + '\'' +
                ", toDeptNbr='" + toDeptNbr + '\'' +
                ", toMajClNbr='" + toMajClNbr + '\'' +
                ", toSubClNbr='" + toSubClNbr + '\'' +
                ", frIntrUpcId='" + frIntrUpcId + '\'' +
                ", toIntrUpcId='" + toIntrUpcId + '\'' +
                ", poNbr='" + poNbr + '\'' +
                ", rcvrSeqNbr='" + rcvrSeqNbr + '\'' +
                ", filter='" + filter + '\'' +
                '}';
    }
}

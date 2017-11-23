package com.butlerx;

import java.util.ArrayList;
import java.util.List;

import com.butlerx.admin.model.RecordDetails;

public class RecordStore {
    public static List<RecordDetails> recordList;

    static {
        RecordStore.resetRecord();
    }

    public static void resetRecord() {
        RecordStore.recordList = new ArrayList<RecordDetails>();

        RecordDetails recordDetails1 = new RecordDetails();
        recordDetails1.setAgreementDate("TBC");
        recordDetails1.setBorrower("HL Global Enterprises Limited");
        recordDetails1.setClientDescription("Escrow");
        recordDetails1.setDocDescription("Share Transfer form dated 22 November 2017 (Original)");
        recordDetails1.setId("1");
        recordDetails1.setLastCheckedBy("Satish Srivastava");
        recordDetails1.setLastCheckedDate("17/11/2017");
        recordDetails1.setLegalCounsel("TBC");
        recordDetails1.setLocation("A2");
        recordDetails1.setNumCopies("1");
        recordDetails1.setOriginalCTC("");
        recordDetails1.setReceiveDate("17/11/2017");
        recordDetails1.setRemarks("");
        recordDetails1.setRoles("Escrow Agent");
        recordDetails1.setUpdatePrepareBy("Muneet Mand");
        recordDetails1.setUpdatePrepareDate("17/11/2017");

        RecordDetails recordDetails2 = new RecordDetails();
        recordDetails2.setAgreementDate("TBC");
        recordDetails2.setBorrower("HL Global Enterprises Limited");
        recordDetails2.setClientDescription("Escrow");
        recordDetails2
            .setDocDescription("Share Certificate No. 3 of LKN Investment International Pte Ltd (\"LKNII\") (2 Ordinary Shares)");
        recordDetails2.setId("2");
        recordDetails2.setLastCheckedBy("Satish Srivastava");
        recordDetails2.setLastCheckedDate("17/11/2017");
        recordDetails2.setLegalCounsel("TBC");
        recordDetails2.setLocation("A2");
        recordDetails2.setNumCopies("1");
        recordDetails2.setOriginalCTC("");
        recordDetails2.setReceiveDate("17/11/2017");
        recordDetails2.setRemarks("");
        recordDetails2.setRoles("Escrow Agent");
        recordDetails2.setUpdatePrepareBy("Muneet Mand");
        recordDetails2.setUpdatePrepareDate("17/11/2017");

        RecordDetails recordDetails3 = new RecordDetails();
        recordDetails3.setAgreementDate("TBC");
        recordDetails3.setBorrower("HL Global Enterprises Limited");
        recordDetails3.setClientDescription("Escrow");
        recordDetails3.setDocDescription("Share Certificate No. 4 of LKNII (500,000 Ordinary Shares)");
        recordDetails3.setId("3");
        recordDetails3.setLastCheckedBy("Satish Srivastava");
        recordDetails3.setLastCheckedDate("17/11/2017");
        recordDetails3.setLegalCounsel("TBC");
        recordDetails3.setLocation("A2");
        recordDetails3.setNumCopies("1");
        recordDetails3.setOriginalCTC("");
        recordDetails3.setReceiveDate("17/11/2017");
        recordDetails3.setRemarks("");
        recordDetails3.setRoles("Escrow Agent");
        recordDetails3.setUpdatePrepareBy("Muneet Mand");
        recordDetails3.setUpdatePrepareDate("17/11/2017");

        RecordDetails recordDetails4 = new RecordDetails();
        recordDetails4.setAgreementDate("TBC");
        recordDetails4.setBorrower("HL Global Enterprises Limited");
        recordDetails4.setClientDescription("Escrow");
        recordDetails4.setDocDescription("Share Certificate No. 5 of LKNII (499,998 Ordinary Shares)");
        recordDetails4.setId("4");
        recordDetails4.setLastCheckedBy("Satish Srivastava");
        recordDetails4.setLastCheckedDate("17/11/2017");
        recordDetails4.setLegalCounsel("TBC");
        recordDetails4.setLocation("A2");
        recordDetails4.setNumCopies("1");
        recordDetails4.setOriginalCTC("");
        recordDetails4.setReceiveDate("17/11/2017");
        recordDetails4.setRemarks("");
        recordDetails4.setRoles("Escrow Agent");
        recordDetails4.setUpdatePrepareBy("Muneet Mand");
        recordDetails4.setUpdatePrepareDate("17/11/2017");

        RecordDetails recordDetails5 = new RecordDetails();
        recordDetails5.setAgreementDate("TBC");
        recordDetails5.setBorrower("HL Global Enterprises Limited");
        recordDetails5.setClientDescription("Escrow");
        recordDetails5.setDocDescription("Share Certificate No. 8 of LKNII (12,233,000 Ordinary Shares)");
        recordDetails5.setId("5");
        recordDetails5.setLastCheckedBy("Satish Srivastava");
        recordDetails5.setLastCheckedDate("17/11/2017");
        recordDetails5.setLegalCounsel("TBC");
        recordDetails5.setLocation("A2");
        recordDetails5.setNumCopies("1");
        recordDetails5.setOriginalCTC("");
        recordDetails5.setReceiveDate("17/11/2017");
        recordDetails5.setRemarks("");
        recordDetails5.setRoles("Escrow Agent");
        recordDetails5.setUpdatePrepareBy("Muneet Mand");
        recordDetails5.setUpdatePrepareDate("17/11/2017");


        RecordStore.recordList.add(recordDetails1);
        RecordStore.recordList.add(recordDetails2);
        RecordStore.recordList.add(recordDetails3);
        RecordStore.recordList.add(recordDetails4);
        RecordStore.recordList.add(recordDetails5);
    }

}

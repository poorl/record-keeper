package com.butlerx.api;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.butlerx.RecordStore;
import com.butlerx.admin.RecordApiDelegate;
import com.butlerx.admin.model.RecordDetails;
import com.butlerx.admin.model.RecordRequest;
import com.butlerx.admin.model.ResponseMessage;

@Component
public class RecordApi implements RecordApiDelegate {
	private static final RecordStore store = new RecordStore();
	//private static final String DEFAULT_DATE_FORMAT = "dd MMM yyyy hh:mm a";
	private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
	private static final String SQL_CREATE_RECORD = "INSERT INTO records(borrower, agreementDate, clientDescription, "
			+ "roles, legalCounsel, docDescription, numCopies, receiveDate, location, originalCTC, remarks, updatePrepareBy, "
			+ "updatePrepareDate, lastCheckedBy, lastCheckedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#confirmRecord(java.lang.String)
	 */
	@Override
	public ResponseEntity<RecordDetails> confirmRecord(String id) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.confirmRecord(id);
	}

	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#createRecord(com.butlerx.admin.model.RecordRequest)
	 */
	@Override
	public ResponseEntity<RecordDetails> createRecord(RecordRequest body) {
		String nowString = OffsetDateTime.now().format(FORMATTER);
		RecordDetails details = new RecordDetails();
		
		details.setAgreementDate(body.getAgreementDate());
		details.setBorrower(body.getBorrower());
		details.setDocDescription(body.getDocDescription());
		details.setClientDescription(body.getClientDescription());
		details.setLastCheckedBy("Record Creator");
		details.setLastCheckedDate(nowString);
		details.setLegalCounsel(body.getLegalCounsel());
		details.setLocation(body.getLocation());
		details.setNumCopies(body.getNumCopies());
		details.setOriginalCTC(body.getOriginalCTC());
		details.setReceiveDate(nowString);
		details.setRemarks(body.getRemarks());
		details.setRoles(body.getRoles());
		details.setUpdatePrepareBy("Record Creator");
		details.setUpdatePrepareDate(nowString);
		
		RecordStore.recordList.add(details);
		details.setId(Integer.toString(RecordStore.recordList.size()));
		return new ResponseEntity<RecordDetails>(details, HttpStatus.OK);
	}

	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#deleteRecord(java.lang.String)
	 */
	@Override
	public ResponseEntity<ResponseMessage> deleteRecord(String id) {
		// TODO Auto-generated method stub
		RecordStore.resetRecord();
		return RecordApiDelegate.super.deleteRecord(id);
	}

	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#finishLoc(java.lang.String)
	 */
	@Override
	public ResponseEntity<Void> finishLoc(String id) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.finishLoc(id);
	}

	/* (non-Javadoc)0
	 * @see com.butlerx.admin.RecordApiDelegate#getRecord(java.lang.String)
	 */
	@Override
	public ResponseEntity<RecordDetails> getRecord(String id) {
		int i = Integer.parseInt(id);
		if (i >= RecordStore.recordList.size() || i <= 0) {
			i = 0;
		} else {
			i -= 1;
		}
		return new ResponseEntity<RecordDetails>(RecordStore.recordList.get(i), HttpStatus.OK);
	}

	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#listRecord()
	 */
	@Override
	public ResponseEntity<List<RecordDetails>> listRecord() {
		return new ResponseEntity<List<RecordDetails>>(RecordStore.recordList, HttpStatus.OK);
	}

	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#startLoc(java.lang.String)
	 */
	@Override
	public ResponseEntity<Void> startLoc(String id) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.startLoc(id);
	}

	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#updateRecord(java.lang.String, com.butlerx.admin.model.RecordRequest)
	 */
	@Override
	public ResponseEntity<RecordDetails> updateRecord(String id, RecordRequest body) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.updateRecord(id, body);
	}
}

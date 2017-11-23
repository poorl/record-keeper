package com.butlerx.api;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.annotation.WebServlet;

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
		//KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		
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
		/*
		try {
			this.jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement ps = conn.prepareStatement(SQL_CREATE_RECORD, new String[] {"id"});
					ps.setString(1, details.getBorrower());
					ps.setString(2, details.getAgreementDate());
					ps.setString(3, details.getClientDescription());
					ps.setString(4, details.getRoles());
					ps.setString(5, details.getLegalCounsel());
					ps.setString(6, details.getDocDescription());
					ps.setString(7, details.getNumCopies());
					ps.setString(8, details.getReceiveDate());
					ps.setString(9, details.getLocation());
					ps.setString(10, details.getOriginalCTC());
					ps.setString(11, details.getRemarks());
					ps.setString(12, details.getUpdatePrepareBy());
					ps.setString(13, details.getUpdatePrepareDate());
					ps.setString(14, details.getLastCheckedBy());
					ps.setString(15, details.getLastCheckedDate());
					return ps;
				}
			}, generatedKeyHolder);
		} catch (DuplicateKeyException e) {
			System.out.println("Duplicated key");
			System.out.println(e);
			throw new RuntimeException(e);
		}*/
		/*
		try (PreparedStatement stateCreateRecord = conn.prepareStatement(SQL_CREATE_RECORD)) {
			stateCreateRecord.setString(1, details.getBorrower());
			stateCreateRecord.setString(2, details.getAgreementDate());
			stateCreateRecord.setString(3, details.getClientDescription());
			stateCreateRecord.setString(4, details.getRoles());
			stateCreateRecord.setString(5, details.getLegalCounsel());
			stateCreateRecord.setString(6, details.getDocDescription());
			stateCreateRecord.setString(7, details.getNumCopies());
			stateCreateRecord.setString(8, details.getReceiveDate());
			stateCreateRecord.setString(9, details.getLocation());
			stateCreateRecord.setString(10, details.getOriginalCTC());
			stateCreateRecord.setString(11, details.getRemarks());
			stateCreateRecord.setString(12, details.getUpdatePrepareBy());
			stateCreateRecord.setString(13, details.getUpdatePrepareDate());
			stateCreateRecord.setString(14, details.getLastCheckedBy());
			stateCreateRecord.setString(15, details.getLastCheckedDate());
			stateCreateRecord.executeUpdate();
			String key = stateCreateRecord.getGeneratedKeys().getString(0);
			details.setId(key);			
		} catch (SQLException exception) {
			System.out.println("SQL error");
			System.out.println(exception);
		}*/
		//details.setId(generatedKeyHolder.getKey().toString());
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
		if (i >= RecordStore.recordList.size()) {
			i = 0;
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

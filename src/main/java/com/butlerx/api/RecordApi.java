package com.butlerx.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.butlerx.admin.RecordApiDelegate;
import com.butlerx.admin.model.RecordDetails;
import com.butlerx.admin.model.RecordRequest;
import com.butlerx.admin.model.ResponseMessage;

@Component
public class RecordApi implements RecordApiDelegate {

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
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.createRecord(body);
	}

	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#deleteRecord(java.lang.String)
	 */
	@Override
	public ResponseEntity<ResponseMessage> deleteRecord(String id) {
		// TODO Auto-generated method stub
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

	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#getRecord(java.lang.String)
	 */
	@Override
	public ResponseEntity<RecordDetails> getRecord(String id) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.getRecord(id);
	}

	/* (non-Javadoc)
	 * @see com.butlerx.admin.RecordApiDelegate#listRecord()
	 */
	@Override
	public ResponseEntity<List<RecordDetails>> listRecord() {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.listRecord();
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

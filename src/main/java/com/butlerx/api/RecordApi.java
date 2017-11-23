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

	@Override
	public ResponseEntity<RecordDetails> confirmRecord(Long id) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.confirmRecord(id);
	}

	@Override
	public ResponseEntity<RecordDetails> createRecord(RecordRequest body) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.createRecord(body);
	}

	@Override
	public ResponseEntity<ResponseMessage> deleteRecord(Long id) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.deleteRecord(id);
	}

	@Override
	public ResponseEntity<Void> finishLoc(String id) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.finishLoc(id);
	}

	@Override
	public ResponseEntity<RecordDetails> getRecord(Long id) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.getRecord(id);
	}

	@Override
	public ResponseEntity<List<RecordDetails>> listRecord() {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.listRecord();
	}

	@Override
	public ResponseEntity<Void> startLoc(String id) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.startLoc(id);
	}

	@Override
	public ResponseEntity<RecordDetails> updateRecord(Long id, RecordRequest body) {
		// TODO Auto-generated method stub
		return RecordApiDelegate.super.updateRecord(id, body);
	}

}

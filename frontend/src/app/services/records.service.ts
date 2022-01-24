import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class RecordsService {

  constructor(
    private _record:HttpClient
  ) { }

  // add record 
  public addRecord(record:any){
    return this._record.post(`${baseUrl}/user-activities/`, record);
  }

  // update record
  public updateRecord(record:any){
    return this._record.put(`${baseUrl}/user-activities/`, record);
  }

  // get all records
  public getAllRecords(){
    return this._record.get(`${baseUrl}/user-activities/`);
  }

  // get one record
  public getSingleRecord(aId:any){
    return this._record.get(`${baseUrl}/user-activities/${aId}`);
  }

  // delete record
  public deleteRecord(aId:any){
    return this._record.delete(`${baseUrl}/user-activities/${aId}`);
  }

  // get records of quiz
  public getRecordsOfQuiz(qId:any){
    return this._record.get(`${baseUrl}/user-activities/quiz/${qId}`);
  }

  // get records of user
  public getRecordsOfUser(username:any){
    return this._record.get(`${baseUrl}/user-activities/user/${username}`);
  }
}

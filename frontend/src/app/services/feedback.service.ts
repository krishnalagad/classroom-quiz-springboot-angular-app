import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(
    private _http: HttpClient
  ) { }

  // add feedback
  public addFeedback(feedback: any){
    return this._http.post(`${baseUrl}/user-feedback/`, feedback);
  }

  // update feedback
  public updateFeedback(feedback: any){
    return this._http.put(`${baseUrl}/user-feedback/`, feedback);
  }

  // delete feedback
  public deleteFeedback(fid: any){
    return this._http.delete(`${baseUrl}/user-feedback/${fid}`);
  }

  // get feedback
  public getFeedback(fid: any){
    return this._http.get(`${baseUrl}/user-feedback/${fid}`);
  }

  // get all feedbacks
  public getAllFeedbacks(){
    return this._http.get(`${baseUrl}/user-feedback/`);
  }

  // get feedbacks of user
  public getFeedbacksOfUser(username: any){
    return this._http.get(`${baseUrl}/user-feedback/user/${username}`);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(
    private _http:HttpClient
  ) { }

  // get all questions of quiz
  public getQuestionsOfQuiz(qid:any){
    return this._http.get(`${baseUrl}/question/quiz/all/${qid}`);
  }

  // add question
  public addQuestion(question:any){
    return this._http.post(`${baseUrl}/question/`, question);
  }

  // delete question
  public deleteQuestion(questionId:any){
    return this._http.delete(`${baseUrl}/question/${questionId}`);
  }

  // get single question
  public getQuestion(quesId:any){
    return this._http.get(`${baseUrl}/question/${quesId}`);
  }

  // update question
  public updateQuestion(question:any){
    return this._http.put(`${baseUrl}/question/`, question);
  }

  // get all questions of quiz for user
  public getLimitedQuestionsOfQuiz(qid:any){
    return this._http.get(`${baseUrl}/question/quiz/${qid}`);
  }
}

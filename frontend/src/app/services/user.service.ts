import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { } 

  //add user
  public addUser(user:any){
    return this.http.post(`${baseUrl}/user/`, user);
  }

  // get user
  public getUser(username:any){
    return this.http.get(`${baseUrl}/user/${username}`);
  }

  // get all users
  public getUsers(){
    return this.http.get(`${baseUrl}/user/`);
  }

  // delete user 
  public deleteUser(userId:any){
    return this.http.delete(`${baseUrl}/user/${userId}`);
  }

  // otp
  public verifyotp(otpData: any){
    return this.http.post(`${baseUrl}/user/v/`, otpData);
  }
}

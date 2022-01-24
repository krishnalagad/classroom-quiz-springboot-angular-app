import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject = new Subject<boolean>();

  constructor(private http: HttpClient) { }

  // Currently logged in users data
  public getCurrentUser(){
    return this.http.get(`${baseUrl}/current-user`)
  }

  // Generate Token
  public generateToken(loginData:any){

    return this.http.post(`${baseUrl}/generate-token`, loginData);
  }

  // Login user: set token in local storage
  public loginUser(token:any){

    localStorage.setItem('token', token);
    return true;
  }

  // isLogin: user is logged in or not
  public isLoggedIn(){
    let tokenStr = localStorage.getItem('token');
    if(tokenStr == undefined || tokenStr == '' || tokenStr == null){
      return false;
    } 
    else{
      return true;
    }
  }

  // logout: remove token from local storage
  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  // getToken: 
  public getToken(){
    return localStorage.getItem('token');
  }

  // setUserDetails
  public setUser(user:any){
    localStorage.setItem('user', JSON.stringify(user));
  }

  // getUser
  public getUser(){
    let userStr = localStorage.getItem('user');
    if(userStr != null){
      return JSON.parse(userStr);
    }
    else{
      this.logout();
      return null;
    }
  }

  // getUserRole
  public getUserRole(){
    let user = this.getUser();
    return user.authorities[0].authority;
  }
}

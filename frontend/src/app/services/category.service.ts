import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private _http:HttpClient) { }

  // Load all the categories
  public categories(){
    return this._http.get(`${baseUrl}/category/`);
  }

  // add new category
  public addCategory(category:any){
    return this._http.post(`${baseUrl}/category/`, category);
  }

  // delete category
  public deleteCategory(cid:any){
    return this._http.delete(`${baseUrl}/category/${cid}`);
  }

  // get one category
  public getCategory(cid:any){
    return this._http.get(`${baseUrl}/category/${cid}`);
  }

  // update category
  public updateCategory(category:any){
    return this._http.put(`${baseUrl}/category/`, category);
  }
  
}

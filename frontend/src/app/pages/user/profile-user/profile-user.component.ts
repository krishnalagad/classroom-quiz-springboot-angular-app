import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-profile-user',
  templateUrl: './profile-user.component.html',
  styleUrls: ['./profile-user.component.css']
})
export class ProfileUserComponent implements OnInit {

  user: any;

  // image related variables
  // image related variables
  selectedFile!: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string | undefined;
  imageName: any;

  constructor(
    private login: LoginService,
    private _snack: MatSnackBar,
    private httpClient: HttpClient,
  ) { }

  ngOnInit(): void {
    this.user = this.login.getUser();
    console.log(this.user);
    this.getImage(this.user.id);
  }

  dev() {
    this._snack.open('This module is under development', 'Ok', {
      duration: 3000
    });
  }

  public onFileChanged(event:any) {
    //Select File
    this.selectedFile = event.target.files[0];
    // console.log(this.selectedFile);
    
    this.onUpload(this.user.id);
  }

  //Gets called when the user clicks on submit to upload the image
  onUpload(user: any) {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
    uploadImageData.append('user_id', user);
    uploadImageData.append('id', this.retrieveResonse.id);

    //Make a call to the Spring Boot Application to save the image
    this.httpClient.put('http://localhost:8080/user/upload-u', uploadImageData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          
          this.message = 'Document uploaded successfully';
          // console.log('success');
          // this.ngOnInit();
          window.location.reload();
        } else {
          this.message = 'Document not uploaded successfully';
          console.log('failed');
          // this.ngOnInit();
          window.location.reload();
        }
      }
      );


  }

  //Gets called when the user clicks on retieve image button to get the image from back end
  getImage(id: any) {
    //Make a call to Sprinf Boot to get the Image Bytes.
    this.httpClient.get('http://localhost:8080/user/get/' + id)
      .subscribe(
        res => {
          this.retrieveResonse = res;
          console.log(this.retrieveResonse);
          this.base64Data = this.retrieveResonse.picByte;
          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
          // console.log(this.retrievedImage);
        }
      );
  }

}

import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FeedbackService } from 'src/app/services/feedback.service';
import { LoginService } from 'src/app/services/login.service';
import { RecordsService } from 'src/app/services/records.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css'],
})
export class UserHomeComponent implements OnInit {
  arr: any = [
    {
      "name" : 'krishna',
      "value" : 9000
    },
    {
      "name" : "lagad",
      "value" : 2000
    },
    {
      "name" : "varsha",
      "value" : 3000
    },
    {
      "name" : "geeta",
      "value" : 5000
    },
  ];

  view: any[] = [700, 370];
  colorScheme = {
    domain: ['#704FCA', '#48852C', '#867A3D', '#5B6FCB', '#25706F']
  };
  schemeType: string = 'ordinal';
  gradient: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  legendTitle: string = 'Products';
  legendTitleMulti: string = 'Months';
  legendPosition: string = 'below';
  legend: boolean = true;
  showXAxisLabel: boolean = true;
  showYAxisLabel: boolean = true;
  yAxisLabel: string = 'Sales';
  xAxisLabel: string = 'Products';
  animations: boolean = true;
  showGridLines: boolean = true;
  showDataLabel: boolean = true;
  barPadding: number = 5;
  tooltipDisabled: boolean = false;
  roundEdges: boolean = true;

  user:any;

  records:any;

  marks: Array<any>;
  qname: Array<any>;

  currtime: any;
  userName: any;

  feed = 
  {
    'ftitle': '',
    'fcategory': '',
    'fdesc': '',
    'ftime': '',
    'username': ''
  };

  constructor(
    private _login: LoginService,
    private _record: RecordsService,
    private _snack: MatSnackBar,
    private _feedback: FeedbackService
  ) { 
    this.marks = new Array<any>();
    this.qname = new Array<any>();
  } 

  ngOnInit(): void { 
    this.user = this._login.getUser();

    let username = this.user.username;
    this.userName = this.user.username;

    this._record.getRecordsOfUser(username).subscribe(
      (data:any)=>{
        this.records = data;
        console.log(this.records);
        for(let val of data){
          this.marks.push(val.obtainedMarks);
          this.qname.push(val.quiz.title);
        }
      },
      (error: any)=>{
        Swal.fire('Error', 'Error in loading data.', 'error');
      }
    );      
  }

  getCurrentTime(){
    let date: Date = new Date();
    this.currtime = date.toString();
    this.currtime = this.currtime.split(' ', 5);
    let d = this.currtime[1] + ' ' + this.currtime[2] + ' ' + this.currtime[3];
    let t = this.currtime[4];
    let time = d + ' ' + t;
    console.log('Date: ' + d + 'Time: ' + t);
    return time;
  }

  subform(){
    // alert('tezt');
    if(this.feed.ftitle.trim() == '' || this.feed.ftitle.trim() == null){
      this._snack.open('Please enter feedback title', 'Ok', {
        duration: 3000,
        horizontalPosition: 'right',
        verticalPosition: 'bottom'
      });
      return;
    }

    if(this.feed.fcategory.trim() == '' || this.feed.fcategory.trim() == null){
      this._snack.open('Please choose feedback category', 'Ok', {
        duration: 3000,
        horizontalPosition: 'right',
        verticalPosition: 'bottom'
      });
      return;
    }

    if(this.feed.fdesc.trim() == '' || this.feed.fdesc.trim() == null){
      this._snack.open('Please enter feedback description', 'Ok', {
        duration: 3000,
        horizontalPosition: 'right',
        verticalPosition: 'bottom'
      });
      return;
    }

    if(this.feed.fdesc.length > 250){
      this._snack.open('Description content should not exceed 250 characters.', 'Ok', {
        duration: 3000,
        horizontalPosition: 'right',
        verticalPosition: 'bottom'
      });
      return;
    }

    this.feed.ftime = this.getCurrentTime();
    this.feed.username = this.userName;

    // console.log(this.feed);
    this._feedback.addFeedback(this.feed).subscribe(
      (data: any)=>{
        Swal.fire('Success', 'Your feedback has been submitted successfully.', 'success');
        this.feed = 
        {
          'ftitle': '',
          'fcategory': '',
          'fdesc': '',
          'ftime': '',
          'username': ''
        };
      },
      (error: any)=>{
        Swal.fire('Error', 'Something went wrong while submitting your feedback.', 'error');
      }
    );


  }
}

// let htmlRef = this.elementRef.nativeElement.querySelector(`#yourCavasId`);
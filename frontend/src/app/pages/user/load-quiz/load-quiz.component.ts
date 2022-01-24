import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-load-quiz',
  templateUrl: './load-quiz.component.html',
  styleUrls: ['./load-quiz.component.css']
})
export class LoadQuizComponent implements OnInit { 

  catId: any;
  quizzes: any;

  username: any;

  constructor(
    private _route:ActivatedRoute,
    private _quiz:QuizService,
  ) { }

  ngOnInit(): void {
    // this.username = this._route.snapshot.params.uname;
    this.preventRightClick();
    // console.log(this.catId);

    this._route.params.subscribe((params) => {
      this.catId = params.catId;

      if(this.catId == 0){
        console.log('Load all quizzes.');
  
        this._quiz.getActiveQuizzes().subscribe(
          (data:any)=>{
            this.quizzes = data;
            // console.log(this.quizzes);
          },
          (error:any)=>{
            Swal.fire('Error', 'Error in loading data(quiz) from server.', 'error');
          }
        );
      }
      else{
        console.log('Load specific quiz.');
        // this.quizzes = [];
        this._quiz.getActiveQuizzesOfCategory(this.catId).subscribe(
          (data:any)=>{
            this.quizzes = data;
          },
          (error:any)=>{
            Swal.fire('Error', 'Error in loading data(quizzes) from server.', 'error');
          }
        );
      }
    });
  }

  preventRightClick(){
    document.addEventListener('contextmenu', (e) => {
      e.preventDefault();
    });
  }
}

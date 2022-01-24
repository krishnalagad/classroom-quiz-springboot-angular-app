import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { QuestionService } from 'src/app/services/question.service';
import { QuizService } from 'src/app/services/quiz.service';
import { RecordsService } from 'src/app/services/records.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-start-quiz',
  templateUrl: './start-quiz.component.html',
  styleUrls: ['./start-quiz.component.css']
})
export class StartQuizComponent implements OnInit {

  qid: any;
  questions: any;

  marksGot = 0;
  correctAnswers = 0;
  attempted = 0;

  isSubmit = false;
  timer: any;

  blinkFlag = false;

  // records variables and objects
  record: any;
  quiz: any;
  user: any;


  constructor(
    private _locationst:LocationStrategy,
    private _route:ActivatedRoute,
    private _question:QuestionService,
    private _login:LoginService,
    private _quiz:QuizService,
    private _record:RecordsService
  ) { }

  ngOnInit(): void {
    this.preventBackButton();
    this.qid = this._route.snapshot.params.qid;
    this.loadQuestionsForUser();
    this.preventRightClick();

    this.user = this._login.getUser();
    // console.log(this.user);

    this._quiz.getQuiz(this.qid).subscribe(
      (data:any)=>{
        this.quiz = data;
        console.log(this.quiz);
      },
      (error:any)=>{
        console.log(error)
      }
    );

  }

  loadQuestionsForUser() {
    this._question.getLimitedQuestionsOfQuiz(this.qid).subscribe(
      (data:any)=>{
        // console.log(data);
        this.questions = data;

        // set value to timer
        this.timer = this.questions.length * 2 * 60;

        this.questions.forEach((q:any) => {
          q['givenAnswer'] = '';
        });
        this.startTimer();
      },
      (error:any)=>{
        console.log(error);
        Swal.fire('Error', 'Error occured : '+error, 'error');
      }
    );
  }

  preventBackButton(){
    window.history.pushState(null, 'N', location.href);
    this._locationst.onPopState(
      () => {
        window.history.pushState(null, 'N', location.href);
      }
    );
  }

  submitQuiz(){
    Swal.fire(
      {
        title: 'Do you want to submit the quiz ?',
        showCancelButton: true,
        confirmButtonText: 'Submit',
        icon: 'question'
      }
    ).then(
      (e)=>{
        if(e.isConfirmed){
          this.submitQuizAfterTimer();
        }
      }
    );
  }

  startTimer(){
    let t = window.setInterval(()=>{
      // code to be executed after interval.
      if(this.timer <= 0){
        this.submitQuizAfterTimer();
        clearInterval(t);
      }
      else{
        this.timer--;
      }
    }, 1000);
  }

  getFormattedTime(){
    let mins = Math.floor(this.timer / 60);
    let sec = this.timer - mins * 60;
    return `${mins} : ${sec}`;
  }

  submitQuizAfterTimer(){
    this.isSubmit = true;
    // perform calculation of submitted quiz.
    this.questions.forEach((q:any)=>{
      if(q.givenAnswer == q.answer){
          this.correctAnswers++;
          let marksSingle = this.questions[0].quiz.maxMarks / this.questions.length;
          this.marksGot += marksSingle;
          this.marksGot = parseFloat(Number(this.marksGot).toFixed(2));
      }

      if(q.givenAnswer.trim() != ''){
        this.attempted++;
      }
    });
    // let raw: any = new Date().toLocaleString(undefined, {timeZone: 'Asia/Kolkata'});
    // let day:any = raw.getDate();
    // let month:any = raw.getMonth()+1;
    // let year:any = raw.getFullYear();

    // let hours:any = raw.getHours();
    // let minutes:any = raw.getMinutes();
    // let seconds:any = raw.getSeconds();


    let currentDate: Date = new Date();
    this.record = {
      obtainedMarks: this.marksGot,
      attemptedQuestions: this.attempted,
      correctAttempted: this.correctAnswers,
      date: currentDate,
      username: this.user.username,
      quiz: this.quiz,
      // user: this.user,
    };

    this._record.addRecord(this.record).subscribe(
      (data:any)=>{
        console.log('data inserted successfully..');
        console.log(data);
        Swal.fire('Success', 'Exam completed successfully, Thank You..', 'success');
      },
      (error:any)=>{
        Swal.fire('Error', 'Error adding record in database..', 'error');
      }
    );
  }

  preventRightClick(){
    document.addEventListener('contextmenu', (e) => {
      e.preventDefault();
    });
  }

  printResult(){
    window.print();
  }

}
function getMonth() {
  throw new Error('Function not implemented.');
}


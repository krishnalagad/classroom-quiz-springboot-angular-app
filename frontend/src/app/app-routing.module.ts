import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';
import { AddQuestionComponent } from './pages/admin/add-question/add-question.component';
import { AddQuizComponent } from './pages/admin/add-quiz/add-quiz.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UpdateCategoryComponent } from './pages/admin/update-category/update-category.component';
import { UpdateQuestionComponent } from './pages/admin/update-question/update-question.component';
import { UpdateQuizComponent } from './pages/admin/update-quiz/update-quiz.component';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { ViewQuizQuestionsComponent } from './pages/admin/view-quiz-questions/view-quiz-questions.component';
import { ViewQuizzesComponent } from './pages/admin/view-quizzes/view-quizzes.component';
import { ViewUsersComponent } from './pages/admin/view-users/view-users.component';
import { ViewClickedUserComponent } from './pages/admin/view-clicked-user/view-clicked-user.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoadQuizComponent } from './pages/user/load-quiz/load-quiz.component';
import { PrequizInstructionsComponent } from './pages/user/prequiz-instructions/prequiz-instructions.component';
import { ProfileUserComponent } from './pages/user/profile-user/profile-user.component';
import { StartQuizComponent } from './pages/user/start-quiz/start-quiz.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { UserHomeComponent } from './pages/user/user-home/user-home.component';
import { UserSettingsComponent } from './pages/user/user-settings/user-settings.component';
import { AdminGuard } from './services/admin.guard';
import { NormalGuard } from './services/normal.guard';
import { ViewQuizRecordsComponent } from './pages/admin/view-quiz-records/view-quiz-records.component';
import { ViewUserRecordsComponent } from './pages/admin/view-user-records/view-user-records.component';
import { ViewFeedbacksComponent } from './pages/admin/view-feedbacks/view-feedbacks.component';
const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'signup',
    component:SignupComponent,
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'admin',
    component: DashboardComponent,
    // pathMatch: 'full',
    canActivate: [AdminGuard],
    children: [
      {
        path: '',
        component: WelcomeComponent,
      },
      {
        path: 'feedbacks',
        component: ViewFeedbacksComponent
      },
      {
        path: 'view-users',
        component: ViewUsersComponent,
      },
      {
        path: 'view-user/:uname',
        component: ViewClickedUserComponent
      },
      {
        path: 'view-user-records/:uname',
        component: ViewUserRecordsComponent
      },
      {
        path: 'profile',
        component: ProfileComponent,
      },
      {
        path: 'categories',
        component: ViewCategoriesComponent
      },
      {
        path: 'add-category',
        component: AddCategoryComponent
      },
      {
        path: 'quizzes',
        component: ViewQuizzesComponent
      },
      {
        path: 'add-quiz',
        component: AddQuizComponent
      },
      {
        path: 'update-quiz/:qid',
        component: UpdateQuizComponent,
      },
      {
        path: 'view-record/:qid',
        component: ViewQuizRecordsComponent
      },
      {
        path: 'view-questions/:qid/:title',
        component: ViewQuizQuestionsComponent,
      },
      {
        path: 'add-question/:qid/:title',
        component: AddQuestionComponent,
      },
      {
        path: 'update-question/:quesId/:qid/:title',
        component: UpdateQuestionComponent
      },
      {
        path: 'update-category/:cid/:title',
        component: UpdateCategoryComponent
      }
    ],
  },
  {
    path: 'user-dashboard',
    component: UserDashboardComponent,
    // pathMatch: 'full',
    canActivate: [NormalGuard],
    children: [
      {
        path: 'user-home',
        component: UserHomeComponent
      },
      {
        path: 'user-profile',
        component: ProfileUserComponent
      },
      {
        path: 'settings',
        component: UserSettingsComponent
      },
      {
        path: ':catId',
        component: LoadQuizComponent
      },
      {
        path: 'instructions/:qid',
        component: PrequizInstructionsComponent,
      },
      
    ],
  },
  {
    path: 'start-quiz/:qid',
    component: StartQuizComponent,
    canActivate: [NormalGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

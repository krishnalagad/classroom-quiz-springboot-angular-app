import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatButtonModule } from '@angular/material/button';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component'; 

import { MatInputModule } from '@angular/material/input'; 
import { MatFormFieldModule } from '@angular/material/form-field'; 
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { from } from 'rxjs';
import { MatIconModule } from '@angular/material/icon';
import { authInterceptorProviders } from './services/auth.interceptor';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { MatListModule } from '@angular/material/list';
import { SidebarComponent } from './pages/admin/sidebar/sidebar.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';
import { ViewQuizzesComponent } from './pages/admin/view-quizzes/view-quizzes.component';
import { AddQuizComponent } from './pages/admin/add-quiz/add-quiz.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSelectModule } from '@angular/material/select';
import { UpdateQuizComponent } from './pages/admin/update-quiz/update-quiz.component';
import { ViewQuizQuestionsComponent } from './pages/admin/view-quiz-questions/view-quiz-questions.component';
import { AddQuestionComponent } from './pages/admin/add-question/add-question.component';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import { UpdateQuestionComponent } from './pages/admin/update-question/update-question.component';
import { UpdateCategoryComponent } from './pages/admin/update-category/update-category.component';
import { SidebarComponent as UserSidebar } from './pages/user/sidebar/sidebar.component';
import { LoadQuizComponent } from './pages/user/load-quiz/load-quiz.component';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { PrequizInstructionsComponent } from './pages/user/prequiz-instructions/prequiz-instructions.component';
import { StartQuizComponent } from './pages/user/start-quiz/start-quiz.component';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { NgxUiLoaderHttpModule, NgxUiLoaderModule } from 'ngx-ui-loader';
import { ProfileUserComponent } from './pages/user/profile-user/profile-user.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatExpansionModule } from '@angular/material/expansion';
import { UserHomeComponent } from './pages/user/user-home/user-home.component';
import { MatRippleModule } from '@angular/material/core';
import { UserSettingsComponent } from './pages/user/user-settings/user-settings.component';
import { ViewUsersComponent } from './pages/admin/view-users/view-users.component';
import { ViewClickedUserComponent } from './pages/admin/view-clicked-user/view-clicked-user.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatDividerModule } from '@angular/material/divider';
import { MatDialogModule } from '@angular/material/dialog';
import { ViewUserRecordsComponent } from './pages/admin/view-user-records/view-user-records.component';
import { ViewQuizRecordsComponent } from './pages/admin/view-quiz-records/view-quiz-records.component';
import { MatTabsModule } from '@angular/material/tabs'; 
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { ViewFeedbacksComponent } from './pages/admin/view-feedbacks/view-feedbacks.component';
// import { ChartsModule } from 'ng2-charts';
// import { Chart } from 'chart.js';
import { SimplebarAngularModule } from 'simplebar-angular';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    DashboardComponent,
    UserDashboardComponent,
    ProfileComponent,
    SidebarComponent,
    WelcomeComponent,
    ViewCategoriesComponent,
    AddCategoryComponent,
    ViewQuizzesComponent,
    AddQuizComponent,
    UpdateQuizComponent,
    ViewQuizQuestionsComponent,
    AddQuestionComponent,
    UpdateQuestionComponent,
    UpdateCategoryComponent,
    UserSidebar,
    LoadQuizComponent,
    PrequizInstructionsComponent,
    StartQuizComponent,
    ProfileUserComponent,
    UserHomeComponent,
    UserSettingsComponent,
    ViewUsersComponent,
    ViewClickedUserComponent,
    ViewUserRecordsComponent,
    ViewQuizRecordsComponent,
    ViewFeedbacksComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatSlideToggleModule,
    MatSelectModule,
    CKEditorModule,
    ScrollingModule,
    MatProgressSpinnerModule,
    NgxUiLoaderModule,
    MatCheckboxModule,
    MatExpansionModule,
    MatRippleModule,
    MatDividerModule,
    MatSidenavModule,
    MatDialogModule,
    MatTabsModule,
    NgxChartsModule,
    // ChartsModule,
    // Chart,
    SimplebarAngularModule,
    NgxUiLoaderHttpModule.forRoot({
      showForeground: true,
    }),
  ],
  entryComponents: [ViewClickedUserComponent],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }

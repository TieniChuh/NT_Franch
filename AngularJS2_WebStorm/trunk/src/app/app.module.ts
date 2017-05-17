import { NgModule } from '@angular/core'
import { RouterModule } from '@angular/router';
import { rootRouterConfig } from './app.routes';
import { AppComponent } from './app.component';
import { GithubService } from './github/shared/github.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';

import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { RepoBrowserComponent } from './github/repo-browser/repo-browser.component';
import { RepoListComponent } from './github/repo-list/repo-list.component';
import { RepoDetailComponent } from './github/repo-detail/repo-detail.component';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { ContactComponent } from './contact/contact.component';
 //Add personal begin
import { PersonalComponent } from './personal/personal.component';
//Add personal end
//add todo_list begin
import { TodoListComponent }    from './todo/list/list.component';
import { TodoDetailComponent }  from './todo/detail/detail.component';
import { TodoItemComponent }  from './todo/item/item.component';
import { TodoService } from './todo/todo.service';
import { CommonModule }   from '@angular/common';
//add todo_list end
//Add template_driven_forms begin
import { TemplateFormsComponent } from './driven_forms/template-forms/template-forms.component';
import { ReactiveFormsComponent } from './driven_forms/reactive-forms/reactive-forms.component';
import { MobileValidator } from './driven_forms/validators/mobile.validator';
//add template_driven_forms end
@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    RepoBrowserComponent,
    RepoListComponent,
    RepoDetailComponent,
    HomeComponent,
    ContactComponent, //Add personal begin
    PersonalComponent//Add personal end
     ,TodoItemComponent,TodoListComponent, TodoDetailComponent
    ,TemplateFormsComponent,ReactiveFormsComponent,MobileValidator
  ],
  imports: [
    BrowserModule,
    FormsModule,CommonModule,
    ReactiveFormsModule,
    HttpModule,
    RouterModule.forRoot(rootRouterConfig, { useHash: true })
  ],
  providers: [
    GithubService,TodoService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {

}

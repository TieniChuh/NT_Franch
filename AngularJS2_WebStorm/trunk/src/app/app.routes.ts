import {Routes} from '@angular/router';

import {AboutComponent} from './about/about.component';
import {HomeComponent} from './home/home.component';
import {RepoBrowserComponent} from './github/repo-browser/repo-browser.component';
import {RepoListComponent} from './github/repo-list/repo-list.component';
import {RepoDetailComponent} from './github/repo-detail/repo-detail.component';
import {ContactComponent} from './contact/contact.component';
//Add personal begin
import {PersonalComponent} from './personal/personal.component';
//Add personal end
//add todo_list begin
import { TodoRoutes } from './todo/todo.routes';
//add todo_list end
//add  driven_forms begin
import { TemplateFormsRoutes } from './driven_forms/template-forms/template-forms.routes';
import { ReactiveFormsRoutes } from './driven_forms/reactive-forms/reactive-forms.routes';

//add  driven_forms end
export const rootRouterConfig: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
//Add personal begin
  {path: 'personal', component: PersonalComponent},
  //Add personal end
  //add todo_list begin
    ...TodoRoutes,
  //add todo_list end
  //add driven_froms being
  ...TemplateFormsRoutes,
  ...ReactiveFormsRoutes,
//add driven_forms end
  {path: 'about', component: AboutComponent},
  {
    path: 'github', component: RepoBrowserComponent,
    children: [
      {path: '', component: RepoListComponent},
      {
        path: ':org', component: RepoListComponent,
        children: [
          {path: '', component: RepoDetailComponent},
          {path: ':repo', component: RepoDetailComponent}
        ]
      }]
  },
  {path: 'contact', component: ContactComponent}
];


import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import CustomValidators from '../forms/CustomValidators';
import { NgFor } from "@angular/common";
 @Component({
  selector: 'app-personal',
  templateUrl: 'personal.component.html',
  styleUrls: ['personal-component.css']
})
export class PersonalComponent implements OnInit {
  votes:number;
  title:string;
  link:string;

  logName: string = 'defaultLogName';
  items: Array<String>;
  contactForm: FormGroup;
  constructor(private formBuilder: FormBuilder) {
    this.votes = 10;
    this.title = 'Angular 2';
    this.link = 'http://angular.io';

    this.items = [
      "Hillary Clinton",
      "Martin O'Malley",
      "Bernie Sanders"
    ]
  }

  ngOnInit() {
    this.contactForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, CustomValidators.validateEmail]],
      content: ['', [Validators.required, Validators.minLength(10)]]
    });
  }
  submitForm(): void {
    console.log(this.contactForm);
  }
  callPhone(value):void{
    alert("callPhone"+value);
  }
  callFax(value):void{
    alert("callFax:"+value);
  }

  doSomething($event){
    console.log('点击了这个按钮：',$event.target);
  }
  voteUp() {
    this.votes += 1;
  }

  voteDown() {
    this.votes -= 1;
  }
}

import {Component} from '@angular/core';
import {Todo} from '../todo.model';
import {TodoService} from '../todo.service';
@Component({
  selector: 'todo-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class TodoListComponent {
  newTodo: Todo = new Todo();

  constructor(private todoService: TodoService) {
  }

  addTodo() {
    this.todoService.addTodo(this.newTodo);
    this.newTodo = new Todo();
  }

  get todos() {
    return this.todoService.getAllTodos();
  }
}

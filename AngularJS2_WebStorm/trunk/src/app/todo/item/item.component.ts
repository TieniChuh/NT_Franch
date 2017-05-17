import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from '../todo.model';
import { TodoService } from '../todo.service';
@Component({
  selector: 'todo-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']

})
export class TodoItemComponent {
  @Input() todo: Todo;

  constructor(private todoService: TodoService, private router: Router) { }
  // 跳转到任务详情页
  gotoDetail(todo) {
    this.router.navigate(['/todo/detail', todo.id]);
  }
  // 标记一个任务完成/未完成
  toggleTodoComplete(todo) {
    this.todoService.toggleTodoComplete(todo);
  }
  // 删除一个任务
  removeTodo(todo) {
    this.todoService.deleteTodoById(todo.id);
  }
}

import { Component } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-news-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './news-form.component.html',
  styleUrl: './news-form.component.css',
})
export class NewsFormComponent {
  newsForm = new FormGroup({
    title: new FormControl('', Validators.required),
    subtitle: new FormControl(''),
    content: new FormControl('', Validators.required),
    author: new FormControl('', Validators.required),
  });

  handleSubmit() {
    if (this.newsForm.status === 'INVALID') {
      return;
    }
  }
}

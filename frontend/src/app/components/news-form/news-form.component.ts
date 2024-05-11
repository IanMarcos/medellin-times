import { Component } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { NewsApi } from '../../api/NewsApi';
import { NewArticle } from '../../../types/types';
import { ResponseService } from '../../service/response.service';

@Component({
  selector: 'app-news-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './news-form.component.html',
  styleUrl: './news-form.component.css',
  providers: [NewsApi],
})
export class NewsFormComponent {
  constructor(
    private newsApi: NewsApi,
    private responseService: ResponseService
  ) {}

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

    this.newsApi
      .postNews(this.newsForm.value as NewArticle)
      .subscribe((data) => {
        this.responseService.setResponse(JSON.stringify(data, null, 2));
      });
  }
}

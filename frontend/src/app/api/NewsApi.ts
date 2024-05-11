import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NewArticle, News } from '../../types/types';

@Injectable()
export class NewsApi {
  constructor(private http: HttpClient) {}

  postNews(body: NewArticle) {
    const apiURL = 'http://localhost:8080/news';
    return this.http.post<News>(apiURL, body);
  }
}

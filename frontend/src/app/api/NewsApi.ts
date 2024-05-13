import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NewArticle, News } from '../../types/types';

@Injectable()
export class NewsApi {
  private apiURL;

  constructor(private http: HttpClient) {
    this.apiURL = 'http://localhost:8080';
  }

  postNews(body: NewArticle) {
    const url = this.apiURL + '/news';
    return this.http.post<News>(url, body);
  }

  getAllNews() {
    const url = this.apiURL + '/news';
    return this.http.get<News>(url);
  }
}

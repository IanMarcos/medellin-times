import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ResponseService {
  private responseSource = new BehaviorSubject<string>('');

  response$ = this.responseSource.asObservable();

  setResponse(json: string) {
    this.responseSource.next(json);
  }

  constructor() {}
}

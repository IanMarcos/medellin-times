import { Component } from '@angular/core';
import { ResponseService } from '../../service/response.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-response-box',
  standalone: true,
  templateUrl: './response-box.component.html',
  styleUrl: './response-box.component.css',
})
export class ResponseBoxComponent {
  jsonResponse: string = '';
  subscription: Subscription;

  constructor(private responseService: ResponseService) {
    this.subscription = responseService.response$.subscribe((json) => {
      this.jsonResponse = json;
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}

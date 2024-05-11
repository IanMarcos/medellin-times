import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NewsFormComponent } from './components/news-form/news-form.component';
import { ResponseBoxComponent } from './components/response-box/response-box.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NewsFormComponent, ResponseBoxComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'frontend';
}

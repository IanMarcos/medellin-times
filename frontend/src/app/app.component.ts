import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NewsFormComponent } from './components/news-form/news-form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NewsFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'frontend';
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-notification',
  imports: [CommonModule],
  providers: [NotificationService], // Component-level provider
  templateUrl: './notification.component.html',
  styleUrl: './notification.component.css',
})
export class Notification {
  // Why this creates a new separate instance scoped to this component:
  // Providing a service in the component's 'providers' array creates a scoped injector.
  // Angular's DI system searches the injector tree starting from the component itself.
  // Because it is defined here, every instance of NotificationComponent will receive its own unique,
  // fresh instance of NotificationService rather than using the application-wide singleton.

  newMsg = '';

  constructor(private notificationService: NotificationService) {
    // Add a default sample notification
    this.notificationService.addNotification('Welcome to the notifications center!');
  }

  get notifications(): string[] {
    return this.notificationService.getNotifications();
  }

  sendNotification(msg: string): void {
    if (msg.trim()) {
      this.notificationService.addNotification(msg);
    }
  }
}


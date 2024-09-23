import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth/auth.service';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup-client',
  templateUrl: './signup-client.component.html',
  styleUrl: './signup-client.component.scss',
})
export class SignupClientComponent {
  validateForm!: FormGroup;
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private notification: NzNotificationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: [null, [Validators.required]],
      lastname: [null, [Validators.required]],
      phone: [null],
      email: [null, [Validators.email, Validators.required]],
      password: [null, [Validators.required]],
      confirmPassword: [null, [Validators.required]],
    });
  }

  submitForm() {
    this.authService.registerClient(this.validateForm.value).subscribe(
      (res) => {
        this.notification.success('SUCCESS', 'Signup Successful', {
          nzDuration: 5000,
        });
        this.router.navigateByUrl('/login');
      },
      (error) => {
        this.notification.error('ERROR', error.error.message, {
          nzDuration: 5000,
        });
        console.error(error);
      }
    );
  }
}

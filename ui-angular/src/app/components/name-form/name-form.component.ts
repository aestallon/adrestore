import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PersonNameUpdate } from 'src/app/api/adrestore';

@Component({
  selector: 'app-name-form',
  templateUrl: './name-form.component.html',
  styleUrls: ['./name-form.component.css']
})
export class NameFormComponent {

  constructor(
    public dialogRef: MatDialogRef<NameFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data?: PersonNameUpdate
  ) { }

  onCancel(): void {
    this.dialogRef.close();
  }

}

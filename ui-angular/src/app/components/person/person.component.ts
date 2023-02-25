import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PersonDetail, PersonService } from 'src/app/api/adrestore';
import { NameFormComponent } from '../name-form/name-form.component';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  @Input() personDetail?: PersonDetail;
  @Output() deletePersonEvent = new EventEmitter<number>();
  @Output() closeEvent = new EventEmitter<void>();
  @Output() nameChangedEvent = new EventEmitter<void>();

  constructor(
    private service: PersonService,
    private saveSnackBar: MatSnackBar,
    public nameChangeDialog: MatDialog
  ) { }

  ngOnInit(): void {
  }

  canSave(): boolean {
    return this.personDetail != null && this.personDetail != undefined;
  }

  async saveAddressData(): Promise<void> {
    if (this.personDetail) {
      console.log(this.personDetail);
      this.personDetail = await this.service.updatePersonAddress(
        this.personDetail.id!,
        {
          permanentAddress: this.personDetail.permanentAddress!,
          temporaryAddress: this.personDetail.temporaryAddress!
        }
      ).toPromise();
      this.saveSnackBar.open('Save successful!', undefined, {
        duration: 3_000,

      });
    }
  }

  editName(): void {
    let dialogRef = this.nameChangeDialog.open(NameFormComponent, {
      data: {
        firstName: this.personDetail!.firstName,
        lastName: this.personDetail!.lastName
      }
    });
    dialogRef.afterClosed().subscribe(async result => {
      console.log(result);
      console.log('Dialog closed!');
      this.personDetail = await this.service
        .updatePersonName(this.personDetail!.id!, result)
        .toPromise();
      this.nameChangedEvent.emit();
    });
  }

  async deletePerson(): Promise<void> {
    let personId = this.personDetail?.id!;
    this.personDetail = undefined;
    this.deletePersonEvent.emit(personId);
  }

  close(): void {
    this.closeEvent.emit();
  }

}

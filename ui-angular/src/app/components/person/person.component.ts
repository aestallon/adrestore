import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PersonDetail, PersonService } from 'src/app/api/adrestore';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  @Input() personDetail?: PersonDetail;
  @Output() deletePersonEvent = new EventEmitter<number>();
  @Output() closeEvent = new EventEmitter<void>();

  constructor(private service: PersonService, private saveSnackBar: MatSnackBar) { }

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

  async deletePerson(): Promise<void> {
    let personId = this.personDetail?.id!;
    this.personDetail = undefined;
    this.deletePersonEvent.emit(personId);
  }

  close(): void {
    this.closeEvent.emit();
  }

}

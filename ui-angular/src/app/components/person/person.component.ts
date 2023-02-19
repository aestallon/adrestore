import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { PersonDetail, PersonService } from 'src/app/api/adrestore';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  @Input() personDetail?: PersonDetail;
  @Output() deletePersonEvent = new EventEmitter<number>();

  permanentCountry?: FormControl;
  permanentTown?: FormControl;
  permanentStreet?: FormControl;
  permanentStrNum?: FormControl;

  constructor(private service: PersonService) { }

  ngOnInit(): void {
  }

  canSave(): boolean {
    return this.personDetail != null && this.personDetail != undefined;
  }

  async saveAddressData(): Promise<void> {
    if (this.personDetail) {
      this.service.updatePersonAddress(
        this.personDetail.id!,
        {
          permanentAddress: this.personDetail.permanentAddress!,
          temporaryAddress: this.personDetail.temporaryAddress!
        }
      );
    }
  }

  async deletePerson(): Promise<void> {
    let personId = this.personDetail?.id!;
    this.personDetail = undefined;
    this.deletePersonEvent.emit(personId);
  }



}

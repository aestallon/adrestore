import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { PersonPreview } from 'src/app/api/adrestore';

@Component({
  selector: 'app-person-card',
  templateUrl: './person-card.component.html',
  styleUrls: ['./person-card.component.css']
})
export class PersonCardComponent implements OnInit {

  @Input() personPreview?: PersonPreview;
  @Output() selectPersonEvent = new EventEmitter<number>();
  @Output() deletePersonEvent = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  selectPerson() {
    this.selectPersonEvent.emit(this.personPreview!.id!);
  }

  deletePerson() {
    this.deletePersonEvent.emit(this.personPreview!.id!);
  }

}

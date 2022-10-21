import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appCloseDataTable]'
})
export class CloseDataTableDirective {

  constructor(private el: ElementRef) { }

  @HostListener('clickaway') onMouseEnter() {
    // @Input () activeTable = '';
  }

}

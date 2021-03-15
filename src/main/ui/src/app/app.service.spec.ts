import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClientModule } from '@angular/common/http';
import { AppService } from './app.service';

describe('AppService', () => {
  let service: AppService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AppService]
    });
    service = TestBed.inject(AppService);
  });

  it('should be created', () => {
    // tslint:disable-next-line: deprecation
    const service: AppService = TestBed.get(AppService);
    expect(service).toBeTruthy();
  });

  it('should have getEntries function', () => {
    const service: AppService = TestBed.get(AppService);
    expect(service.getEntries).toBeTruthy();
  });

  it('should have checkConversion function', () => {
    const service: AppService = TestBed.get(AppService);
    expect(service.checkConversion).toBeTruthy();
  });

});

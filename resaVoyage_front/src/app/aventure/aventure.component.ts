 import { Component, OnInit } from '@angular/core';
 import {AventureService} from "../services/aventure.service";
 import {Aventure} from "../../shared/models/aventure";
 import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-aventure',
  templateUrl: './aventure.component.html',
  styleUrls: ['./aventure.component.css']
})
export class AventureComponent implements OnInit {
  public allAventures:Aventure[] = [];
  public aventuresByCat:Aventure[] = [];
  public aventure:Aventure;
  public aventureList:Aventure[] = [];
  constructor(private route: ActivatedRoute, private aventureService: AventureService) { }

  ngOnInit() {
    this.getAllAventures();
  }

  getAllAventures(){
    this.aventureService.getAllAventures().subscribe((res)=>{
      this.allAventures = res;

      for (let i=1; i<5; i++){
        this.aventureList.push(this.allAventures[i]);
      }
      console.log("tessssssssst ",  this.allAventures );
    });
  }

  getAventureById(id:number){
    return this.aventureService.getAventureById(id).subscribe((res)=>{
        this.aventure = res;
        //JSON.stringify(this.aventure);
        console.log("aventure by Id is good avec id :",  this.aventure);

    });
  }



}

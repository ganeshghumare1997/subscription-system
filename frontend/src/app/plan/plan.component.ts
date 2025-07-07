import { Component, OnInit } from "@angular/core";
import { AgGridModule } from "ag-grid-angular";
import * as $ from "jquery";
import { GlobalServiceService } from "../global-service.service";

@Component({
  selector: "app-plan",
  templateUrl: "./plan.component.html",
  styleUrls: ["./plan.component.css"],
})
export class PlanComponent implements OnInit {
  ratePlanList = [];

  constructor(private globalService: GlobalServiceService) {}

  ngOnInit(): void {
    const payload = {
      pageNo: 0, // you can allow pagination later
    };

    this.globalService.getRatePlans(payload).subscribe({
      next: (res: any) => {
        this.ratePlanList = res.ratePlanList || [];
      },
      error: (err) => {
        console.error("Error fetching rate plans", err);
      },
    });
  }
}

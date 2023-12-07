import { Component } from "@angular/core";
import { RouterModule } from "@angular/router";
import { UserService } from "../service/user.service";
import { CommonModule } from "@angular/common";

@Component({
    templateUrl:'./header.component.html',
    styleUrls:['./header.component.css'],
    imports: [CommonModule, RouterModule],
    selector:'app-header',
    standalone:true
})

class HeaderComponent{
    message:string="Student Management App"
    constructor(public service: UserService) {}

    sayHello():string{
        return "In hello"
    }
}
export default HeaderComponent;
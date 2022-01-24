import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";

const TOKEN_HEADRER = 'Authorization';

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private login: LoginService){}

    intercept(
        req: HttpRequest<any>, 
        next: HttpHandler
    ): Observable<HttpEvent<any>> {


        // throw new Error("Method not implemented.");

        //add the jwt token (localStorage) request.
        let authReq = req;
        const token = this.login.getToken();
        console.log('inside interceptor');
        if(token != null){

            authReq = authReq.clone({
                setHeaders: {Authorization:`Bearer ${token}` },
            });
        }
        return next.handle(authReq);
    }
}

export const authInterceptorProviders = [
    {
        provide:HTTP_INTERCEPTORS,
        useClass:AuthInterceptor,
        multi:true,
    },
];
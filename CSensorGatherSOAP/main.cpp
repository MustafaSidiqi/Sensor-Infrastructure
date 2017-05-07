/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: nb
 *
 * Created on May 5, 2017, 5:58 PM
 */

#include <cstdlib>
#include "soapAPI/soapH.h"
#include "soapAPI/DockImpSOAPPortBinding.nsmap"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    struct soap *soap = soap_new(); 
    
    //soap_out_ns1__requestConnectionSOAP(struct soap*, const char*, int, const struct ns1__requestConnectionSOAP *, const char*);

    return 0;
}


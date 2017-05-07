// Reminder: Modify typemap.dat to customize the header file generated by wsdl2h
/* csoapapi.h
   Generated by wsdl2h 2.8.41 from http://localhost:7777/ws/sensor?wsdl and typemap.dat
   2017-05-05 16:32:08 GMT

   DO NOT INCLUDE THIS FILE DIRECTLY INTO YOUR PROJECT BUILDS
   USE THE soapcpp2-GENERATED SOURCE CODE FILES FOR YOUR PROJECT BUILDS

gSOAP XML Web services tools
Copyright (C) 2000-2016, Robert van Engelen, Genivia Inc. All Rights Reserved.
This program is released under the GPL with the additional exemption that
compiling, linking, and/or using OpenSSL is allowed.
--------------------------------------------------------------------------------
A commercial use license is available from Genivia Inc., contact@genivia.com
--------------------------------------------------------------------------------
*/

/** @page page_notes Notes

@note HINTS:
 - Run soapcpp2 on csoapapi.h to generate the SOAP/XML processing logic.
   Use soapcpp2 -I to specify paths for #import
   To build with STL, 'stl.h' is imported from 'import' dir in package.
   Use soapcpp2 -j to generate improved proxy and server classes.
   Use soapcpp2 -r to generate a report.
 - Use wsdl2h -c and -s to generate pure C code or C++ code without STL.
 - Use 'typemap.dat' to control namespace bindings and type mappings.
   It is strongly recommended to customize the names of the namespace prefixes
   generated by wsdl2h. To do so, modify the prefix bindings in the Namespaces
   section below and add the modified lines to 'typemap.dat' to rerun wsdl2h.
 - Run Doxygen (www.doxygen.org) on this file to generate documentation.
 - Use wsdl2h -R to generate REST operations.
 - Use wsdl2h -nname to use name as the base namespace prefix instead of 'ns'.
 - Use wsdl2h -Nname for service prefix and produce multiple service bindings
 - Use wsdl2h -d to enable DOM support for xsd:anyType.
 - Use wsdl2h -g to auto-generate readers and writers for root elements.
 - Use wsdl2h -b to auto-generate bi-directional operations (duplex ops).
 - Use wsdl2h -U to map XML names to C++ Unicode identifiers instead of _xNNNN.
 - Use wsdl2h -u to disable the generation of unions.
 - Struct/class members serialized as XML attributes are annotated with a '@'.
 - Struct/class members that have a special role are annotated with a '$'.

@warning
   DO NOT INCLUDE THIS ANNOTATED FILE DIRECTLY IN YOUR PROJECT SOURCE CODE.
   USE THE FILES GENERATED BY soapcpp2 FOR YOUR PROJECT'S SOURCE CODE:
   THE soapStub.h FILE CONTAINS THIS CONTENT WITHOUT ANNOTATIONS.

@copyright LICENSE:
@verbatim
--------------------------------------------------------------------------------
gSOAP XML Web services tools
Copyright (C) 2000-2017, Robert van Engelen, Genivia Inc. All Rights Reserved.
The wsdl2h tool and its generated software are released under the GPL.
This software is released under the GPL with the additional exemption that
compiling, linking, and/or using OpenSSL is allowed.
--------------------------------------------------------------------------------
GPL license.

This program is free software; you can redistribute it and/or modify it under
the terms of the GNU General Public License as published by the Free Software
Foundation; either version 2 of the License, or (at your option) any later
version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with
this program; if not, write to the Free Software Foundation, Inc., 59 Temple
Place, Suite 330, Boston, MA 02111-1307 USA

Author contact information:
engelen@genivia.com / engelen@acm.org

This program is released under the GPL with the additional exemption that
compiling, linking, and/or using OpenSSL is allowed.
--------------------------------------------------------------------------------
A commercial-use license is available from Genivia, Inc., contact@genivia.com
--------------------------------------------------------------------------------
@endverbatim

*/


//gsoapopt c,w

/******************************************************************************\
 *                                                                            *
 * Definitions                                                                *
 *   http://dockingsystem/                                                    *
 *                                                                            *
\******************************************************************************/


/******************************************************************************\
 *                                                                            *
 * Import                                                                     *
 *                                                                            *
\******************************************************************************/


/******************************************************************************\
 *                                                                            *
 * Schema Namespaces                                                          *
 *                                                                            *
\******************************************************************************/


/* NOTE:

It is strongly recommended to customize the names of the namespace prefixes
generated by wsdl2h. To do so, modify the prefix bindings below and add the
modified lines to typemap.dat to rerun wsdl2h:

ns1 = "http://dockingsystem/"

*/

#define SOAP_NAMESPACE_OF_ns1	"http://dockingsystem/"
//gsoap ns1   schema namespace:	http://dockingsystem/
//gsoap ns1   schema form:	unqualified

/******************************************************************************\
 *                                                                            *
 * Built-in Schema Types and Top-Level Elements and Attributes                *
 *                                                                            *
\******************************************************************************/

/// Built-in XSD type "xs:boolean".
enum xsd__boolean { xsd__boolean__false_, xsd__boolean__true_ };



/******************************************************************************\
 *                                                                            *
 * Schema Types and Top-Level Elements and Attributes                         *
 *                                                                            *
 *                                                                            *
\******************************************************************************/


/******************************************************************************\
 *                                                                            *
 * Schema Types and Top-Level Elements and Attributes                         *
 *   http://dockingsystem/                                                    *
 *                                                                            *
\******************************************************************************/


/******************************************************************************\
 *                                                                            *
 * Schema Complex Types and Top-Level Elements                                *
 *                                                                            *
 *                                                                            *
\******************************************************************************/


/******************************************************************************\
 *                                                                            *
 * Schema Complex Types and Top-Level Elements                                *
 *   http://dockingsystem/                                                    *
 *                                                                            *
\******************************************************************************/

/// @brief "http://dockingsystem/":NoSuchAlgorithmException is a complexType.
///
/// struct ns1__NoSuchAlgorithmException operations:
/// - ns1__NoSuchAlgorithmException* soap_new_ns1__NoSuchAlgorithmException(struct soap*, int num) allocate and default initialize one or more values (array)
/// - soap_default_ns1__NoSuchAlgorithmException(struct soap*, ns1__NoSuchAlgorithmException*) default initialize members
/// - int soap_read_ns1__NoSuchAlgorithmException(struct soap*, ns1__NoSuchAlgorithmException*) deserialize from a source
/// - int soap_write_ns1__NoSuchAlgorithmException(struct soap*, ns1__NoSuchAlgorithmException*) serialize to a sink
/// - ns1__NoSuchAlgorithmException* soap_dup_ns1__NoSuchAlgorithmException(struct soap*, ns1__NoSuchAlgorithmException* dst, ns1__NoSuchAlgorithmException *src) returns deep copy of ns1__NoSuchAlgorithmException src into dst, copies the (cyclic) graph structure when a context is provided, or (cycle-pruned) tree structure with soap_set_mode(soap, SOAP_XML_TREE) (use soapcpp2 -Ec)
/// - soap_del_ns1__NoSuchAlgorithmException(ns1__NoSuchAlgorithmException*) deep deletes ns1__NoSuchAlgorithmException data members, use only on dst after soap_dup_ns1__NoSuchAlgorithmException(NULL, ns1__NoSuchAlgorithmException *dst, ns1__NoSuchAlgorithmException *src) (use soapcpp2 -Ed)
struct ns1__NoSuchAlgorithmException
{
/// Element "message" of XSD type xs:string.
    char*                                message                        0;	///< Optional element.
};


/******************************************************************************\
 *                                                                            *
 * Additional Top-Level Elements                                              *
 *                                                                            *
 *                                                                            *
\******************************************************************************/


/******************************************************************************\
 *                                                                            *
 * Additional Top-Level Attributes                                            *
 *                                                                            *
 *                                                                            *
\******************************************************************************/


/******************************************************************************\
 *                                                                            *
 * Additional Top-Level Elements                                              *
 *   http://dockingsystem/                                                    *
 *                                                                            *
\******************************************************************************/

/// @brief Top-level root element "http://dockingsystem/":NoSuchAlgorithmException of XSD type "http://dockingsystem/":NoSuchAlgorithmException.
/// @note Use wsdl2h option -g to auto-generate a top-level root element declaration and processing code.


/******************************************************************************\
 *                                                                            *
 * Additional Top-Level Attributes                                            *
 *   http://dockingsystem/                                                    *
 *                                                                            *
\******************************************************************************/


/******************************************************************************\
 *                                                                            *
 * Services                                                                   *
 *                                                                            *
\******************************************************************************/


//gsoap ns1  service name:	DockImpSOAPPortBinding 
//gsoap ns1  service type:	DockIntSOAP 
//gsoap ns1  service port:	http://localhost:7777/ws/sensor 
//gsoap ns1  service namespace:	http://dockingsystem/ 
//gsoap ns1  service transport:	http://schemas.xmlsoap.org/soap/http 

/** @mainpage DockImpSOAPService Definitions

@section DockImpSOAPService_bindings Service Bindings

  - @ref DockImpSOAPPortBinding

@section DockImpSOAPService_more More Information

  - @ref page_notes "Notes"

  - @ref page_XMLDataBinding "XML Data Binding"

  - @ref SOAP_ENV__Header "SOAP Header Content" (when applicable)

  - @ref SOAP_ENV__Detail "SOAP Fault Detail Content" (when applicable)


*/

/**

@page DockImpSOAPPortBinding Binding "DockImpSOAPPortBinding"

@section DockImpSOAPPortBinding_operations Operations of Binding "DockImpSOAPPortBinding"

  - @ref ns1__transferDataSOAP

  - @ref ns1__requestConnectionSOAP

  - @ref ns1__getNonsenseSOAP

  - @ref ns1__getPublicKeySOAP

  - @ref ns1__sendCipherInonsenseSOAP

  - @ref ns1__sendLogHashCipherSOAP

  - @ref ns1__recieveOKSOAP

@section DockImpSOAPPortBinding_ports Default endpoints of Binding "DockImpSOAPPortBinding"

  - http://localhost:7777/ws/sensor

@note Use wsdl2h option -Nname to change the service binding prefix name


*/

/******************************************************************************\
 *                                                                            *
 * SOAP Fault Detail                                                          *
 *                                                                            *
\******************************************************************************/

/**

The SOAP Fault is part of the gSOAP context and its content is accessed
through the soap.fault->detail variable (SOAP 1.1) or the
soap.fault->SOAP_ENV__Detail variable (SOAP 1.2).
Use wsdl2h option -j to omit these declarations.

*/
mutable struct SOAP_ENV__Detail
{
/// xsd:anyAttribute omitted: to parse attribute content of the Detail element into DOM anyAttribute, use wsdl2h option -d.
/// SOAP Fault message "NoSuchAlgorithmException" part "fault" element ""http://dockingsystem/":NoSuchAlgorithmException".
    struct ns1__NoSuchAlgorithmException*  ns1__NoSuchAlgorithmException ;
    int                                  __type                        ;	///< set to SOAP_TYPE_X for a serializable type X
    void                                *fault                         ;	///< points to serializable object of type X or NULL
    _XML                                 __any                         ;	///< Catch any other content in XML string.
};


/******************************************************************************\
 *                                                                            *
 * Service Binding                                                            *
 *   DockImpSOAPPortBinding                                                   *
 *                                                                            *
\******************************************************************************/


/******************************************************************************\
 *                                                                            *
 * Service Operation                                                          *
 *   ns1__transferDataSOAP                                                    *
 *                                                                            *
\******************************************************************************/

/// Operation response struct "ns1__transferDataSOAPResponse" of operation "ns1__transferDataSOAP".
struct ns1__transferDataSOAPResponse
{
    enum xsd__boolean                   _return_;	///< Output parameter, _ wildcard name as per RPC parameterOrder
};

/** Operation "ns1__transferDataSOAP" of service binding "DockImpSOAPPortBinding".

  - SOAP literal messaging

  - Default endpoints:
    - http://localhost:7777/ws/sensor

  - Addressing input action: "http://dockingsystem/DockIntSOAP/transferDataSOAPRequest"

  - Addressing output action: "http://dockingsystem/DockIntSOAP/transferDataSOAPResponse"

C stub function (defined in soapClient.c[pp] generated by soapcpp2):
@code
  int soap_call_ns1__transferDataSOAP(
    struct soap *soap,
    NULL, // char *endpoint = NULL selects default endpoint for this operation
    NULL, // char *action = NULL selects default action for this operation
    // input parameters:
    char*                               arg0,
    char*                               arg1,
    char*                               arg2,
    int                                 arg3,
    // output parameters:
    struct ns1__transferDataSOAPResponse*
  );
@endcode

C server function (called from the service dispatcher defined in soapServer.c[pp]):
@code
  int ns1__transferDataSOAP(
    struct soap *soap,
    // input parameters:
    char*                               arg0,
    char*                               arg1,
    char*                               arg2,
    int                                 arg3,
    // output parameters:
    struct ns1__transferDataSOAPResponse*
  );
@endcode

*/

//gsoap ns1  service method-protocol:	transferDataSOAP SOAP
//gsoap ns1  service method-style:	transferDataSOAP rpc
//gsoap ns1  service method-encoding:	transferDataSOAP literal
//gsoap ns1  service method-input-action:	transferDataSOAP http://dockingsystem/DockIntSOAP/transferDataSOAPRequest
//gsoap ns1  service method-output-action:	transferDataSOAP http://dockingsystem/DockIntSOAP/transferDataSOAPResponse
int ns1__transferDataSOAP(
    char*                               _arg0,	///< Input parameter, _ wildcard name as per RPC parameterOrder
    char*                               _arg1,	///< Input parameter, _ wildcard name as per RPC parameterOrder
    char*                               _arg2,	///< Input parameter, _ wildcard name as per RPC parameterOrder
    int                                 _arg3,	///< Input parameter, _ wildcard name as per RPC parameterOrder
    struct ns1__transferDataSOAPResponse*	///< Output response struct parameter
);

/******************************************************************************\
 *                                                                            *
 * Service Operation                                                          *
 *   ns1__requestConnectionSOAP                                               *
 *                                                                            *
\******************************************************************************/

/// Operation response struct "ns1__requestConnectionSOAPResponse" of operation "ns1__requestConnectionSOAP".
struct ns1__requestConnectionSOAPResponse
{
    enum xsd__boolean                   return_;	///< Output parameter
};

/** Operation "ns1__requestConnectionSOAP" of service binding "DockImpSOAPPortBinding".

  - SOAP literal messaging

  - Default endpoints:
    - http://localhost:7777/ws/sensor

  - Addressing input action: "http://dockingsystem/DockIntSOAP/requestConnectionSOAPRequest"

  - Addressing output action: "http://dockingsystem/DockIntSOAP/requestConnectionSOAPResponse"

C stub function (defined in soapClient.c[pp] generated by soapcpp2):
@code
  int soap_call_ns1__requestConnectionSOAP(
    struct soap *soap,
    NULL, // char *endpoint = NULL selects default endpoint for this operation
    NULL, // char *action = NULL selects default action for this operation
    // input parameters:
    // output parameters:
    struct ns1__requestConnectionSOAPResponse*
  );
@endcode

C server function (called from the service dispatcher defined in soapServer.c[pp]):
@code
  int ns1__requestConnectionSOAP(
    struct soap *soap,
    // input parameters:
    // output parameters:
    struct ns1__requestConnectionSOAPResponse*
  );
@endcode

*/

//gsoap ns1  service method-protocol:	requestConnectionSOAP SOAP
//gsoap ns1  service method-style:	requestConnectionSOAP rpc
//gsoap ns1  service method-encoding:	requestConnectionSOAP literal
//gsoap ns1  service method-input-action:	requestConnectionSOAP http://dockingsystem/DockIntSOAP/requestConnectionSOAPRequest
//gsoap ns1  service method-output-action:	requestConnectionSOAP http://dockingsystem/DockIntSOAP/requestConnectionSOAPResponse
int ns1__requestConnectionSOAP(
    struct ns1__requestConnectionSOAPResponse*	///< Output response struct parameter
);

/******************************************************************************\
 *                                                                            *
 * Service Operation                                                          *
 *   ns1__getNonsenseSOAP                                                     *
 *                                                                            *
\******************************************************************************/

/// Operation response struct "ns1__getNonsenseSOAPResponse" of operation "ns1__getNonsenseSOAP".
struct ns1__getNonsenseSOAPResponse
{
    char*                               return_;	///< Output parameter
};

/** Operation "ns1__getNonsenseSOAP" of service binding "DockImpSOAPPortBinding".

  - SOAP literal messaging

  - Default endpoints:
    - http://localhost:7777/ws/sensor

  - Addressing input action: "http://dockingsystem/DockIntSOAP/getNonsenseSOAPRequest"

  - Addressing output action: "http://dockingsystem/DockIntSOAP/getNonsenseSOAPResponse"

C stub function (defined in soapClient.c[pp] generated by soapcpp2):
@code
  int soap_call_ns1__getNonsenseSOAP(
    struct soap *soap,
    NULL, // char *endpoint = NULL selects default endpoint for this operation
    NULL, // char *action = NULL selects default action for this operation
    // input parameters:
    // output parameters:
    struct ns1__getNonsenseSOAPResponse*
  );
@endcode

C server function (called from the service dispatcher defined in soapServer.c[pp]):
@code
  int ns1__getNonsenseSOAP(
    struct soap *soap,
    // input parameters:
    // output parameters:
    struct ns1__getNonsenseSOAPResponse*
  );
@endcode

*/

//gsoap ns1  service method-protocol:	getNonsenseSOAP SOAP
//gsoap ns1  service method-style:	getNonsenseSOAP rpc
//gsoap ns1  service method-encoding:	getNonsenseSOAP literal
//gsoap ns1  service method-input-action:	getNonsenseSOAP http://dockingsystem/DockIntSOAP/getNonsenseSOAPRequest
//gsoap ns1  service method-output-action:	getNonsenseSOAP http://dockingsystem/DockIntSOAP/getNonsenseSOAPResponse
int ns1__getNonsenseSOAP(
    struct ns1__getNonsenseSOAPResponse*	///< Output response struct parameter
);

/******************************************************************************\
 *                                                                            *
 * Service Operation                                                          *
 *   ns1__getPublicKeySOAP                                                    *
 *                                                                            *
\******************************************************************************/

/// Operation response struct "ns1__getPublicKeySOAPResponse" of operation "ns1__getPublicKeySOAP".
struct ns1__getPublicKeySOAPResponse
{
    char*                               return_;	///< Output parameter
};

/** Operation "ns1__getPublicKeySOAP" of service binding "DockImpSOAPPortBinding".

  - SOAP literal messaging

  - Default endpoints:
    - http://localhost:7777/ws/sensor

  - Addressing input action: "http://dockingsystem/DockIntSOAP/getPublicKeySOAPRequest"

  - Addressing output action: "http://dockingsystem/DockIntSOAP/getPublicKeySOAPResponse"

  - Output Fault: "http://dockingsystem/":NoSuchAlgorithmException (literal)
    - Output Fault addressing action: "http://dockingsystem/DockIntSOAP/getPublicKeySOAP/Fault/NoSuchAlgorithmException"

C stub function (defined in soapClient.c[pp] generated by soapcpp2):
@code
  int soap_call_ns1__getPublicKeySOAP(
    struct soap *soap,
    NULL, // char *endpoint = NULL selects default endpoint for this operation
    NULL, // char *action = NULL selects default action for this operation
    // input parameters:
    // output parameters:
    struct ns1__getPublicKeySOAPResponse*
  );
@endcode

C server function (called from the service dispatcher defined in soapServer.c[pp]):
@code
  int ns1__getPublicKeySOAP(
    struct soap *soap,
    // input parameters:
    // output parameters:
    struct ns1__getPublicKeySOAPResponse*
  );
@endcode

*/

//gsoap ns1  service method-protocol:	getPublicKeySOAP SOAP
//gsoap ns1  service method-style:	getPublicKeySOAP rpc
//gsoap ns1  service method-encoding:	getPublicKeySOAP literal
//gsoap ns1  service method-input-action:	getPublicKeySOAP http://dockingsystem/DockIntSOAP/getPublicKeySOAPRequest
//gsoap ns1  service method-output-action:	getPublicKeySOAP http://dockingsystem/DockIntSOAP/getPublicKeySOAPResponse
//gsoap ns1  service method-fault:	getPublicKeySOAP ns1__NoSuchAlgorithmException
//gsoap ns1  service method-fault-action:	getPublicKeySOAP http://dockingsystem/DockIntSOAP/getPublicKeySOAP/Fault/NoSuchAlgorithmException
int ns1__getPublicKeySOAP(
    struct ns1__getPublicKeySOAPResponse*	///< Output response struct parameter
);

/******************************************************************************\
 *                                                                            *
 * Service Operation                                                          *
 *   ns1__sendCipherInonsenseSOAP                                             *
 *                                                                            *
\******************************************************************************/

/// Operation response struct "ns1__sendCipherInonsenseSOAPResponse" of operation "ns1__sendCipherInonsenseSOAP".
struct ns1__sendCipherInonsenseSOAPResponse
{
};

/** Operation "ns1__sendCipherInonsenseSOAP" of service binding "DockImpSOAPPortBinding".

  - SOAP literal messaging

  - Default endpoints:
    - http://localhost:7777/ws/sensor

  - Addressing input action: "http://dockingsystem/DockIntSOAP/sendCipherInonsenseSOAPRequest"

  - Addressing output action: "http://dockingsystem/DockIntSOAP/sendCipherInonsenseSOAPResponse"

C stub function (defined in soapClient.c[pp] generated by soapcpp2):
@code
  int soap_call_ns1__sendCipherInonsenseSOAP(
    struct soap *soap,
    NULL, // char *endpoint = NULL selects default endpoint for this operation
    NULL, // char *action = NULL selects default action for this operation
    // input parameters:
    char*                               arg0,
    // output parameters:
    struct ns1__sendCipherInonsenseSOAPResponse*
  );
@endcode

C server function (called from the service dispatcher defined in soapServer.c[pp]):
@code
  int ns1__sendCipherInonsenseSOAP(
    struct soap *soap,
    // input parameters:
    char*                               arg0,
    // output parameters:
    struct ns1__sendCipherInonsenseSOAPResponse*
  );
@endcode

*/

//gsoap ns1  service method-protocol:	sendCipherInonsenseSOAP SOAP
//gsoap ns1  service method-style:	sendCipherInonsenseSOAP rpc
//gsoap ns1  service method-encoding:	sendCipherInonsenseSOAP literal
//gsoap ns1  service method-input-action:	sendCipherInonsenseSOAP http://dockingsystem/DockIntSOAP/sendCipherInonsenseSOAPRequest
//gsoap ns1  service method-output-action:	sendCipherInonsenseSOAP http://dockingsystem/DockIntSOAP/sendCipherInonsenseSOAPResponse
int ns1__sendCipherInonsenseSOAP(
    char*                               arg0,	///< Input parameter
    struct ns1__sendCipherInonsenseSOAPResponse*	///< Output response struct parameter
);

/******************************************************************************\
 *                                                                            *
 * Service Operation                                                          *
 *   ns1__sendLogHashCipherSOAP                                               *
 *                                                                            *
\******************************************************************************/

/// Operation response struct "ns1__sendLogHashCipherSOAPResponse" of operation "ns1__sendLogHashCipherSOAP".
struct ns1__sendLogHashCipherSOAPResponse
{
};

/** Operation "ns1__sendLogHashCipherSOAP" of service binding "DockImpSOAPPortBinding".

  - SOAP literal messaging

  - Default endpoints:
    - http://localhost:7777/ws/sensor

  - Addressing input action: "http://dockingsystem/DockIntSOAP/sendLogHashCipherSOAPRequest"

  - Addressing output action: "http://dockingsystem/DockIntSOAP/sendLogHashCipherSOAPResponse"

C stub function (defined in soapClient.c[pp] generated by soapcpp2):
@code
  int soap_call_ns1__sendLogHashCipherSOAP(
    struct soap *soap,
    NULL, // char *endpoint = NULL selects default endpoint for this operation
    NULL, // char *action = NULL selects default action for this operation
    // input parameters:
    char*                               arg0,
    // output parameters:
    struct ns1__sendLogHashCipherSOAPResponse*
  );
@endcode

C server function (called from the service dispatcher defined in soapServer.c[pp]):
@code
  int ns1__sendLogHashCipherSOAP(
    struct soap *soap,
    // input parameters:
    char*                               arg0,
    // output parameters:
    struct ns1__sendLogHashCipherSOAPResponse*
  );
@endcode

*/

//gsoap ns1  service method-protocol:	sendLogHashCipherSOAP SOAP
//gsoap ns1  service method-style:	sendLogHashCipherSOAP rpc
//gsoap ns1  service method-encoding:	sendLogHashCipherSOAP literal
//gsoap ns1  service method-input-action:	sendLogHashCipherSOAP http://dockingsystem/DockIntSOAP/sendLogHashCipherSOAPRequest
//gsoap ns1  service method-output-action:	sendLogHashCipherSOAP http://dockingsystem/DockIntSOAP/sendLogHashCipherSOAPResponse
int ns1__sendLogHashCipherSOAP(
    char*                               arg0,	///< Input parameter
    struct ns1__sendLogHashCipherSOAPResponse*	///< Output response struct parameter
);

/******************************************************************************\
 *                                                                            *
 * Service Operation                                                          *
 *   ns1__recieveOKSOAP                                                       *
 *                                                                            *
\******************************************************************************/

/// Operation response struct "ns1__recieveOKSOAPResponse" of operation "ns1__recieveOKSOAP".
struct ns1__recieveOKSOAPResponse
{
    enum xsd__boolean                   return_;	///< Output parameter
};

/** Operation "ns1__recieveOKSOAP" of service binding "DockImpSOAPPortBinding".

  - SOAP literal messaging

  - Default endpoints:
    - http://localhost:7777/ws/sensor

  - Addressing input action: "http://dockingsystem/DockIntSOAP/recieveOKSOAPRequest"

  - Addressing output action: "http://dockingsystem/DockIntSOAP/recieveOKSOAPResponse"

  - Output Fault: "http://dockingsystem/":NoSuchAlgorithmException (literal)
    - Output Fault addressing action: "http://dockingsystem/DockIntSOAP/recieveOKSOAP/Fault/NoSuchAlgorithmException"

C stub function (defined in soapClient.c[pp] generated by soapcpp2):
@code
  int soap_call_ns1__recieveOKSOAP(
    struct soap *soap,
    NULL, // char *endpoint = NULL selects default endpoint for this operation
    NULL, // char *action = NULL selects default action for this operation
    // input parameters:
    // output parameters:
    struct ns1__recieveOKSOAPResponse*
  );
@endcode

C server function (called from the service dispatcher defined in soapServer.c[pp]):
@code
  int ns1__recieveOKSOAP(
    struct soap *soap,
    // input parameters:
    // output parameters:
    struct ns1__recieveOKSOAPResponse*
  );
@endcode

*/

//gsoap ns1  service method-protocol:	recieveOKSOAP SOAP
//gsoap ns1  service method-style:	recieveOKSOAP rpc
//gsoap ns1  service method-encoding:	recieveOKSOAP literal
//gsoap ns1  service method-input-action:	recieveOKSOAP http://dockingsystem/DockIntSOAP/recieveOKSOAPRequest
//gsoap ns1  service method-output-action:	recieveOKSOAP http://dockingsystem/DockIntSOAP/recieveOKSOAPResponse
//gsoap ns1  service method-fault:	recieveOKSOAP ns1__NoSuchAlgorithmException
//gsoap ns1  service method-fault-action:	recieveOKSOAP http://dockingsystem/DockIntSOAP/recieveOKSOAP/Fault/NoSuchAlgorithmException
int ns1__recieveOKSOAP(
    struct ns1__recieveOKSOAPResponse  *	///< Output response struct parameter
);

/**

@page DockImpSOAPPortBinding Binding "DockImpSOAPPortBinding"

@section DockImpSOAPPortBinding_policy_enablers Policy Enablers of Binding "DockImpSOAPPortBinding"

None specified.

*/

/******************************************************************************\
 *                                                                            *
 * XML Data Binding                                                           *
 *                                                                            *
\******************************************************************************/


/**

@page page_XMLDataBinding XML Data Binding

SOAP/XML services use data bindings contractually bound by WSDL and auto-
generated by wsdl2h and soapcpp2 (see Service Bindings). Plain data bindings
are adopted from XML schemas as part of the WSDL types section or when running
wsdl2h on a set of schemas to produce non-SOAP-based XML data bindings.

The following readers and writers are C/C++ data type (de)serializers auto-
generated by wsdl2h and soapcpp2. Run soapcpp2 on this file to generate the
(de)serialization code, which is stored in soapC.c[pp]. Include "soapH.h" in
your code to import these data type and function declarations. Only use the
soapcpp2-generated files in your project build. Do not include the wsdl2h-
generated .h file in your code.

Data can be read and deserialized from:
  - an int file descriptor, using soap->recvfd = fd
  - a socket, using soap->socket = (int)...
  - a C++ stream (istream, stringstream), using soap->is = (istream*)...
  - a C string, using soap->is = (const char*)...
  - any input, using the soap->frecv() callback

Data can be serialized and written to:
  - an int file descriptor, using soap->sendfd = (int)...
  - a socket, using soap->socket = (int)...
  - a C++ stream (ostream, stringstream), using soap->os = (ostream*)...
  - a C string, using soap->os = (const char**)...
  - any output, using the soap->fsend() callback

The following options are available for (de)serialization control:
  - soap->encodingStyle = NULL; to remove SOAP 1.1/1.2 encodingStyle
  - soap_mode(soap, SOAP_XML_TREE); XML without id-ref (no cycles!)
  - soap_mode(soap, SOAP_XML_GRAPH); XML with id-ref (including cycles)
  - soap_set_namespaces(soap, struct Namespace *nsmap); to set xmlns bindings


@section default Top-level root elements of schema ""

@section ns1 Top-level root elements of schema "http://dockingsystem/"

  - <ns1:NoSuchAlgorithmException> (use wsdl2h option -g to auto-generate type _ns1__NoSuchAlgorithmException)

*/

/* End of csoapapi.h */

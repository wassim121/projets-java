package CalculModule;


/**
* CalculModule/CalculPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from calcul.idl
* jeudi 7 d�cembre 2023 13 h 28 WAT
*/

public abstract class CalculPOA extends org.omg.PortableServer.Servant
 implements CalculModule.CalculOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable<String, Integer> _methods = new java.util.Hashtable<String, Integer> ();
  static
  {
    _methods.put ("addition", new java.lang.Integer (0));
    _methods.put ("multiplication", new java.lang.Integer (1));
    _methods.put ("soustraction", new java.lang.Integer (2));
    _methods.put ("division", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = _methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CalculModule/Calcul/addition
       {
         float a = in.read_float ();
         float b = in.read_float ();
         double $result = (double)0;
         $result = this.addition (a, b);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 1:  // CalculModule/Calcul/multiplication
       {
         double a = in.read_double ();
         double b = in.read_double ();
         double $result = (double)0;
         $result = this.multiplication (a, b);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 2:  // CalculModule/Calcul/soustraction
       {
         double a = in.read_double ();
         double b = in.read_double ();
         double $result = (double)0;
         $result = this.soustraction (a, b);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 3:  // CalculModule/Calcul/division
       {
         double a = in.read_double ();
         double b = in.read_double ();
         double $result = (double)0;
         $result = this.division (a, b);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CalculModule/Calcul:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Calcul _this() 
  {
    return CalculHelper.narrow(
    super._this_object());
  }

  public Calcul _this(org.omg.CORBA.ORB orb) 
  {
    return CalculHelper.narrow(
    super._this_object(orb));
  }

public double addition(float a, float b) {
	// TODO Auto-generated method stub
	return 0;
}


} // class CalculPOA

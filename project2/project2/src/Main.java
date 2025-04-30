//package PL112_11027125;
//import CYICE.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class MyMap {
  private ArrayList<String> mkeys;
  private ArrayList<String> mvalues;
  public int msize;
  public MyMap() {
    mkeys = new ArrayList<String>();
    mvalues = new ArrayList<String>();
    msize = 0;
  } // MyMap()

  public void Put( String key, String value ) {
    int index = mkeys.indexOf( key );
    if ( index != -1 ) {
      mvalues.set( index, value );
    } // if
    else {
      mkeys.add( key );
      mvalues.add( value );
      msize++;
    } // else
  } // Put()

  public ArrayList<String> GetKeys() {
    return mkeys;
  } // GetKeys()

  public String Get( String key ) {
    int index = mkeys.indexOf( key );
    if ( index != -1 ) {
      return mvalues.get( index );
    } // if

    return null;
  } // Get()

  public boolean ContainsKey( String key ) {
    return mkeys.contains( key );
  } // ContainsKey()

  public void Clear() {
    mkeys.clear();
    mvalues.clear();
    msize = 0;
  } // Clear()

} // class MyMap

class MyFunMap {
  private ArrayList<String> mkeys;
  private ArrayList<Function> mvalues;
  public int msize;
  public MyFunMap() {
    mkeys = new ArrayList<String>();
    mvalues = new ArrayList<Function>();
    msize = 0;
  } // MyFunMap()

  public void Put( String key, Function value ) {
    int index = mkeys.indexOf( key );
    if ( index != -1 ) {
      mvalues.set( index, value );
    } // if
    else {
      mkeys.add( key );
      mvalues.add( value );
      msize++;
    } // else
  } // Put()

  public ArrayList<String> GetKeys() {
    return mkeys;
  } // GetKeys()

  public Function Get( String key ) {
    int index = mkeys.indexOf( key );
    if ( index != -1 ) {
      return mvalues.get( index );
    } // if

    return null;
  } // Get()

  public boolean ContainsKey( String key ) {
    return mkeys.contains( key );
  } // ContainsKey()

  public void Clear() {
    mkeys.clear();
    mvalues.clear();
    msize = 0;
  } // Clear()

} // class MyFunMap

class Function {
  private ArrayList<String> mCodeLines;
  private int mCodelinesize = -1;
  public Function() {
    mCodeLines = new ArrayList<String>();
  } // Function()

  public void AddLine( String line, int lineisdefineorstsatement ) {
    mCodeLines.add( line );
    mCodelinesize++;
  } // AddLine()

  public List<String> GetCodeLines() {
    return mCodeLines;
  } // GetCodeLines()

  public String GetCodeLines( int index ) {
    return mCodeLines.get( index );
  } // GetCodeLines()

  public int GetCodeLinesSize() {
    return mCodelinesize;
  } // GetCodeLinesSize()

  

} // class Function

abstract class VariableType {
  public static final String INT = "INT";
  public static final String FLOAT = "FLOAT";
  public static final String CHAR = "CHAR";
  public static final String BOOLEAN = "BOOLEAN";
  public static final String STRING = "STRING";
  public static final String VOID = "VOID";
} // class VariableType
abstract class FunctionType {
  public static final String DONE = "Done();";
  public static final String LAV = "ListAllVariables();";
  public static final String LAF = "ListAllFunctions();";
  public static final String LV = "ListVariable(char name[]);";
  public static final String LF = "ListFunction(char name[]);";

} // class FunctionType
abstract class TokenType {
  public static final String IDENTIFIER = "IDENTIFIER";
  public static final String CONSTANT = "CONSTANT";
  public static final String IF = "IF";
  public static final String ELSE = "ELSE";
  public static final String WHILE = "WHILE";
  public static final String DO = "DO";
  public static final String RETURN = "RETURN";
  public static final String OPEN_PAREN = "OPEN_PAREN";
  public static final String CLOSE_PAREN = "CLOSE_PAREN";
  public static final String OPEN_BRACKET = "OPEN_BRACKET";
  public static final String CLOSE_BRACKET = "CLOSE_BRACKET";
  public static final String OPEN_BRACE = "OPEN_BRACE";
  public static final String CLOSE_BRACE = "CLOSE_BRACE";
  public static final String ADD = "ADD";
  public static final String SUB = "SUB";
  public static final String MUL = "MUL";
  public static final String DIV = "DIV";
  public static final String MOD = "MOD";
  public static final String CARET = "CARET";
  public static final String LT = "LT";
  public static final String GT = "GT";
  public static final String LE = "LE";
  public static final String GE = "GE";
  public static final String EQ = "EQ";
  public static final String NEQ = "NEQ";
  public static final String ANDD = "ANDD";
  public static final String ORR = "ORR";
  public static final String ASSIGN = "ASSIGN";
  public static final String NOT = "NOT";
  public static final String AND = "AND";
  public static final String OR = "OR";
  public static final String PE = "PE";
  public static final String ME = "ME";
  public static final String TE = "TE";
  public static final String DE = "DE";
  public static final String RE = "RE";
  public static final String PP = "PP";
  public static final String MM = "MM";
  public static final String RS = "RS";
  public static final String LS = "LS";
  public static final String COMMA = "COMMA";
  public static final String SEMICOLON = "SEMICOLON";
  public static final String COLON = "COLON";
  public static final String QUESTION = "QUESTION";
  public static final String UNRECOGNIZEDTOKEN = "Unrecognized token";
  public static final String UNEXPECTEDTOKEN = "Unexpected token";
  public static final String UUNDEFINDEDIDENT = "Undefined identifier";
  public static final String NONE = "None";
} // class TokenType

class ConstantType {
  public static final String INT = "INT";
  public static final String FLOAT = "FLOAT";
  public static final String CHAR = "CHAR";
  public static final String BOOLEAN = "BOOLEAN";
  public static final String STRING = "STRING";
  public static final String CIN = "CIN";
  public static final String COUT = "COUT";
  public static final String NONE = "NONE";
} // class ConstantType
class Token {
  private static final MyMap TOKENTYPEMAP = new MyMap();
  static void InitTOKENTYPEMAP() {
    TOKENTYPEMAP.Put( "if", TokenType.IF );
    TOKENTYPEMAP.Put( "else", TokenType.ELSE );
    TOKENTYPEMAP.Put( "while", TokenType.WHILE ) ;
    TOKENTYPEMAP.Put( "do", TokenType.DO );
    TOKENTYPEMAP.Put( "return", TokenType.RETURN );
    TOKENTYPEMAP.Put( "(", TokenType.OPEN_PAREN );
    TOKENTYPEMAP.Put( ")", TokenType.CLOSE_PAREN );
    TOKENTYPEMAP.Put( "[", TokenType.OPEN_BRACKET );
    TOKENTYPEMAP.Put( "]", TokenType.CLOSE_BRACKET );
    TOKENTYPEMAP.Put( "{", TokenType.OPEN_BRACE );
    TOKENTYPEMAP.Put( "}", TokenType.CLOSE_BRACE );
    TOKENTYPEMAP.Put( "<=", TokenType.LE );
    TOKENTYPEMAP.Put( ">=", TokenType.GE );
    TOKENTYPEMAP.Put( "==", TokenType.EQ );
    TOKENTYPEMAP.Put( "!=", TokenType.NEQ );
    TOKENTYPEMAP.Put( "&&", TokenType.AND );
    TOKENTYPEMAP.Put( "||", TokenType.OR );
    TOKENTYPEMAP.Put( "+=", TokenType.PE );
    TOKENTYPEMAP.Put( "-=", TokenType.ME );
    TOKENTYPEMAP.Put( "*=", TokenType.TE );
    TOKENTYPEMAP.Put( "/=", TokenType.DE );
    TOKENTYPEMAP.Put( "%=", TokenType.RE );
    TOKENTYPEMAP.Put( "++", TokenType.PP );
    TOKENTYPEMAP.Put( "--", TokenType.MM );
    TOKENTYPEMAP.Put( ">>", TokenType.RS );
    TOKENTYPEMAP.Put( "<<", TokenType.LS );
    TOKENTYPEMAP.Put( "<", TokenType.LT );
    TOKENTYPEMAP.Put( ">", TokenType.GT );
    TOKENTYPEMAP.Put( "&", TokenType.ANDD );
    TOKENTYPEMAP.Put( "|", TokenType.ORR );
    TOKENTYPEMAP.Put( "=", TokenType.ASSIGN );
    TOKENTYPEMAP.Put( "!", TokenType.NOT );
    TOKENTYPEMAP.Put( ",", TokenType.COMMA );
    TOKENTYPEMAP.Put( ";", TokenType.SEMICOLON );
    TOKENTYPEMAP.Put( ":", TokenType.COLON );
    TOKENTYPEMAP.Put( "?", TokenType.QUESTION );
    TOKENTYPEMAP.Put( "+", TokenType.ADD );
    TOKENTYPEMAP.Put( "-", TokenType.SUB );
    TOKENTYPEMAP.Put( "*", TokenType.MUL );
    TOKENTYPEMAP.Put( "/", TokenType.DIV );
    TOKENTYPEMAP.Put( "%", TokenType.MOD );
    TOKENTYPEMAP.Put( "^", TokenType.CARET );
  } // InitTOKENTYPEMAP()

  private static final MyMap VARIABLESMAP = new MyMap();
  static void InitVARIABLESMAP() {
    VARIABLESMAP.Put( "int", VariableType.INT );
    VARIABLESMAP.Put( "float", VariableType.FLOAT );
    VARIABLESMAP.Put( "char", VariableType.CHAR );
    VARIABLESMAP.Put( "bool", VariableType.BOOLEAN );
    VARIABLESMAP.Put( "string", VariableType.STRING );
    VARIABLESMAP.Put( "void", VariableType.VOID );
  } // InitVARIABLESMAP()

  private static final MyMap FUNCTIONMAP = new MyMap();
  static void InitFUNCTIONMAP() {
    FUNCTIONMAP.Put( "Done();", FunctionType.DONE );
    FUNCTIONMAP.Put( "ListAllVariables();", FunctionType.LAV );
    FUNCTIONMAP.Put( "ListAllFunctions();", FunctionType.LAF );
    FUNCTIONMAP.Put( "ListVariable(char name[]);", FunctionType.LV );
    FUNCTIONMAP.Put( "ListFunction(char name[]);", FunctionType.LF );
  } // InitFUNCTIONMAP()

  String mType ;
  String mConstanttype;
  String mString ;
  boolean mDefine ;
  double mValue ;
  public static int sLine ;
  public static int sifcout = 0;
  Token( String str, String type, String constanttype ) {
    mString = str ;
    mType = type ;
    mConstanttype = constanttype;
    mDefine = false ;
    mValue = 0 ;
  } // Token()

  Token() {
    mString = "" ;
    mType = TokenType.NONE ;
    mConstanttype = ConstantType.NONE;
    mDefine = false ;
    mValue = 0 ;
  } // Token()

  Vector<Token> mALLToken = new Vector<Token>();
  Vector<String> mAllinput = new Vector<String>();
  Vector<String> mAllline = new Vector<String>();
  String mtempnewinput = null;
  /**
   * @param input
   * @param t
   * @return
  */

  String Iscincout( String input ) {
    if ( input == null ) {
      return null;
    } // if

    Token temp = new Token();
    if ( input.startsWith( "cin" ) ) {
      temp.mString += input.substring( 0, 3 );
      temp.mType = TokenType.CONSTANT;
      temp.mConstanttype = ConstantType.CIN;
      mALLToken.add( temp );
      return input.substring( 3 );
    } // if
    else if ( input.startsWith( "cout" ) ) {
      temp.mString += input.substring( 0, 4 );
      temp.mType = TokenType.CONSTANT;
      temp.mConstanttype = ConstantType.COUT;
      mALLToken.add( temp );
      return input.substring( 4 );
    } // else if

    return input;
  } // Iscincout()

  String Isstring( String input ) {
    if ( input == null ) {
      return null;
    } // if

    Token temp = new Token();
    if ( input.charAt( 0 ) == '\"' ) {
      temp.mString += input.charAt( 0 );
      int i = 1;
      while ( i < input.length() && input.charAt( i ) != '\"' ) {
        temp.mString += input.charAt( i );
        i++;
      } // while

      if ( i < input.length() ) {
        temp.mString += input.charAt( i );
        temp.mType = TokenType.CONSTANT;
        temp.mConstanttype = ConstantType.STRING;
        mALLToken.add( temp );
        return i + 1 < input.length() ? input.substring( i + 1 ) : null;
      } // if
    } // if

    return input;
  } // Isstring()

  String Ischar( String input ) {
    if ( input == null ) {
      return null;
    } // if

    Token temp = new Token();
    if ( input.charAt( 0 ) == '\'' ) {
      temp.mString += input.charAt( 0 );
      int i = 1;
      while ( i < input.length() && input.charAt( i ) != '\'' ) {
        temp.mString += input.charAt( i );
        i++;
      } // while

      if ( i < input.length() ) {
        temp.mString += input.charAt( i );
        temp.mType = TokenType.CONSTANT;
        temp.mConstanttype = ConstantType.STRING;
        mALLToken.add( temp );
        return i + 1 < input.length() ? input.substring( i + 1 ) : null;
      } // if
    } // if

    return input;
  } // Ischar()

  String Isboolean( String input ) {
    if ( input == null ) {
      return null;
    } // if

    Token temp = new Token();
    if ( input.startsWith( "true" ) ) {
      temp.mString += "true";
      temp.mType = TokenType.CONSTANT;
      temp.mConstanttype = ConstantType.BOOLEAN;
      mALLToken.add( temp );
      return input.substring( 4 );
    } // if
    else if ( input.startsWith( "false" ) ) {
      temp.mString += "false";
      temp.mType = TokenType.CONSTANT;
      temp.mConstanttype = ConstantType.BOOLEAN;
      mALLToken.add( temp );
      return input.substring( 5 );
    } // else if

    return input;
  } // Isboolean()

  String Identifier( String input ) {
    if ( input == null ) {
      return null;
    } // if

    Token temp = new Token();
    int i = 0;
    if ( i < input.length() && Character.isLetter( input.charAt( i ) ) ) {
      temp.mString += input.charAt( i );
      i++;
      while ( i < input.length() 
              && ( Character.isDigit( input.charAt( i ) ) 
                   || Character.isLetter( input.charAt( i ) )
                   || input.charAt( i ) == '_' ) ) {
        temp.mString += input.charAt( i );
        i++;
      } // while

      temp.mType = TokenType.IDENTIFIER;
      mALLToken.add( temp );
      return i < input.length() ? input.substring( i ) : null;
    } // if

    return input;
  } // Identifier()

  String IntorFloat( String input ) {
    if ( input == null ) {
      return null;
    } // if

    Token temp = new Token();
    int dot = 0; // count dot
    int i = 0;
    boolean hasnumber = false;
    if ( i < input.length() && ( Character.isDigit( input.charAt( i ) ) || input.charAt( i ) == '.' ) ) {
      if ( input.charAt( i ) == '.' ) dot++;
      else hasnumber = true;
      temp.mString += input.charAt( i );
      i++;
      while ( i < input.length() && ( Character.isDigit( input.charAt( i ) ) 
                                      || input.charAt( i ) == '.' ) ) {
        if ( input.charAt( i ) == '.' ) dot++;
        else hasnumber = true;
        if ( dot > 1 ) {
          temp.mType = TokenType.CONSTANT;
          temp.mConstanttype = ConstantType.FLOAT;
          mALLToken.add( temp );
          return i < input.length() ? input.substring( i ) : null;
        } // if

        temp.mString += input.charAt( i );
        i++;
      } // while

      if ( dot == 1 && hasnumber ) {  // 考慮如果只有一個點的情況
        temp.mType = TokenType.CONSTANT;
        temp.mConstanttype = ConstantType.FLOAT;
        mALLToken.add( temp );
        return i < input.length() ? input.substring( i ) : null;
      } // if
      else if ( dot == 0 && hasnumber ) {
        temp.mType = TokenType.CONSTANT;
        temp.mConstanttype = ConstantType.INT;
        mALLToken.add( temp );
        return i < input.length() ? input.substring( i ) : null;
      } // else if
      else {
        input = ".";
        return input;
      } // else
    } // if

    return input;
  } // IntorFloat()

  String Whichtokentype( String input ) {
    if ( input == null ) {
      return null;
    } // if

    if ( input.charAt( 0 ) == ';' ) {
      if ( input.indexOf( ";" ) != input.length() - 1 ) {
        mtempnewinput = input.substring( input.indexOf( ";" ) + 1, input.length() );
        if ( Islineallspace( mtempnewinput ) ) mtempnewinput = null;
      } // if
      else mtempnewinput = null;
      Token temp = new Token();
      temp.mString += input.charAt( 0 );
      temp.mType = TokenType.SEMICOLON;
      mALLToken.add( temp );
      input = ";";
      return input;
    } // if

    else if ( input.charAt( 0 ) == '}' ) {
      if ( input.indexOf( "}" ) != input.length() - 1 ) {
        mtempnewinput = input.substring( input.indexOf( "}" ) + 1, input.length() );
        if ( Islineallspace( mtempnewinput ) ) mtempnewinput = null;
      } // if
      else mtempnewinput = null;
      Token temp = new Token();
      temp.mString += input.charAt( 0 );
      temp.mType = TokenType.CLOSE_BRACE;
      mALLToken.add( temp );
      input = "}";
      return input;
    } // else if

    else if ( input.charAt( 0 ) == '{' && input.indexOf( "{" ) == input.length() - 1 ) {
      Token temp = new Token();
      temp.mString += input.charAt( 0 );
      temp.mType = TokenType.OPEN_BRACE;
      mALLToken.add( temp );
      input = "{";
      return input.substring( temp.mString.length() );
    } // else if

    for ( int i = 0 ; i < TOKENTYPEMAP.msize ; i++ ) {
      String key = TOKENTYPEMAP.GetKeys().get( i );
      String value = TOKENTYPEMAP.Get( key );
      if ( input.startsWith( key ) ) {
        boolean shouldSkip = false;
        if ( key.equals( "if" ) ) sifcout++;
        else if ( key.equals( "else" ) ) sifcout--;

        if  ( key.equals( "&" ) || key.equals( "|" ) 
              || key.equals( "+" ) || key.equals( ">" ) 
              || key.equals( "<" ) )
          shouldSkip = input.length() > key.length() && input.charAt( key.length() ) == key.charAt( 0 );
        if ( !shouldSkip ) {
          Token temp = new Token();
          temp.mString = key;
          temp.mType = value;
          mALLToken.add( temp );
          return input.substring( key.length() );
        } // if
      } // if
    } // for

    
    return input;
  } // Whichtokentype()

  String Whichvariabletype( String input ) {
    if ( input == null ) {
      return null;
    } // if

    for ( int i = 0 ; i < VARIABLESMAP.msize ; i++ ) {
      String key = VARIABLESMAP.GetKeys().get( i );
      String value = VARIABLESMAP.Get( key );
      if ( input.startsWith( key ) && key.length() < input.length() 
           && ( input.charAt( key.length() ) == ' ' ) ) {
        Token temp = new Token();
        temp.mString = key;
        temp.mType = value;
        mALLToken.add( temp );
        return input.substring( key.length() );
      } // if
      else if ( input.equals( key ) ) {
        Token temp = new Token();
        temp.mString = key;
        temp.mType = value;
        mALLToken.add( temp );
        return input.substring( key.length() );
      } // else if
    } // for

    return input;
  } // Whichvariabletype()

  String WhichFunction( String input ) {
    if ( input == null ) {
      return null;
    } // if

    for ( int i = 0 ; i < FUNCTIONMAP.msize ; i++ ) {
      String key = FUNCTIONMAP.GetKeys().get( i );
      String value = FUNCTIONMAP.Get( key );
      if ( input.startsWith( "ListAllFunctions()" ) ) {
        Token temp = new Token();
        temp.mString = "ListAllFunctions();";
        temp.mType = FunctionType.LAF;
        mALLToken.add( temp );
        return ";";
      } // if

      else if ( input.startsWith( "ListAllVariables()" ) ) {
        Token temp = new Token();
        temp.mString = "ListAllVariables();";
        temp.mType = FunctionType.LAV;
        mALLToken.add( temp );
        return ";";
      } // else if

      else if ( input.startsWith( "ListVariable" ) ) {
        Token temp = new Token();
        temp.mString = input;
        temp.mType = FunctionType.LV;
        mALLToken.add( temp );
        return ";";
      } // else if

      else if ( input.startsWith( "ListFunction" ) ) {
        Token temp = new Token();
        temp.mString = input;
        temp.mType = FunctionType.LF;
        mALLToken.add( temp );
        return ";";
      } // else if

      else if ( input.startsWith( key ) ) {
        Token temp = new Token();
        temp.mString = key;
        temp.mType = value;
        mALLToken.add( temp );
        return input.substring( key.length() );
      } // else if
    } // for

    return input;
  } // WhichFunction()

  String Skipallspace( String input ) {
    char[] chars = new char[input.length()];
    int count = 0;
    for ( int j = 0 ; j < input.length() ; j++ ) {
      char c = input.charAt( j );
      if ( c != ' ' && c != '\t' && c != '\n' ) {
        chars[count++] = c;
      } // if
    } // for

    input = new String( chars, 0, count );
    return input;
  } // Skipallspace()

  boolean Iswhitespace( char input ) {
    if ( input == ' ' || input == '\t' || input == '\n' ) return true;
    return false;
  } // Iswhitespace()
    
  String Skipwhitespace( String input ) {
    while ( !input.isEmpty() && Iswhitespace( input.charAt( 0 ) ) ) {
      input = input.substring( 1 );
    } // while

    return input;
  } // Skipwhitespace()

  String Skiplinecomment( String input ) { // 跳過單行註解
    while ( input.charAt( 0 ) != '\n' ) {
      input = input.substring( 1 );
    } // while

    input = input.substring( 1 );
    return input;
  } // Skiplinecomment()
  
  String Isdone( String input ) {
    if ( input == null ) {
      return null;
    } // if

    if ( input.startsWith( "Done" ) ) {
      Token temp = new Token();
      temp.mString += "Done";
      temp.mType = TokenType.IDENTIFIER;
      mALLToken.add( temp );
      Grammarcheck.svariableMap.Put( temp.mString, temp.mType );
      return input.substring( 4 );
    } // if

    return input;
  } // Isdone()

  boolean End( String input ) {
    if ( input == null ) {
      return false;
    } // if

    String endline = "";
    input = Skipallspace( input );
    if ( input.startsWith( "Done();" ) ) {
      Token temp = new Token();
      temp.mString += input;
      temp.mType = FunctionType.DONE;
      mALLToken.add( temp );
      return true;
    } // if
    else if ( input.equals( "Done" ) || input.equals( "Done(" )  || input.startsWith( "Done()" ) ) {
      endline += input;
      input = Getline();
      input = Skipallspace( input );
      while ( input.equals( "" ) || Islineallspace( input ) ) {
        input = Getline();
        input = Skipallspace( input );
      } // while

      if ( input.startsWith( ";" ) || input.equals( "(" ) || input.equals( ")" ) || input.equals( "()" ) 
           || input.equals( ");" ) || input.equals( "();" ) ) {
        endline += input;
        if ( endline.startsWith( "Done();" ) ) {
          Token temp = new Token();
          temp.mString += input;
          temp.mType = FunctionType.DONE;
          mALLToken.add( temp );
          return true;
        } // if
        else {
          input = Getline();
          input = Skipallspace( input );
          while ( input.equals( "" ) || Islineallspace( input ) ) {
            input = Getline();
            input = Skipallspace( input );
          } // while

          if ( input.equals( ")" ) || input.startsWith( ";" ) || input.equals( ");" ) ) {
            endline += input;
            if ( endline.startsWith( "Done();" ) ) {
              Token temp = new Token();
              temp.mString += input;
              temp.mType = FunctionType.DONE;
              mALLToken.add( temp );
              return true;
            } // if
            else {
              input = Getline();
              input = Skipallspace( input );
              while ( input.equals( "" ) || Islineallspace( input ) ) {
                input = Getline();
                input = Skipallspace( input );
              } // while

              if ( input.startsWith( ";" ) ) {
                endline += input;
                if ( endline.startsWith( "Done();" ) ) {
                  Token temp = new Token();
                  temp.mString += input;
                  temp.mType = FunctionType.DONE;
                  mALLToken.add( temp );
                  return true;
                } // if
              } // if
            } // else
          } // if
        } // else
      } // if
    } // else if

    return false;
  } // End()

  boolean ALLTokenGetter( String input ) {
    Grammarcheck checker = new Grammarcheck( new Vector<Token>() );
    int braces = 0;
    if ( input == null ) {
      System.out.println( "No input received" );
      return false;
    } // if
      
    // System.out.println("Input: " + input);
    boolean breakkk = false;
    if ( mtempnewinput != null ) {
      mtempnewinput = null;
    } // if

    String thisinput = input;
    if ( thisinput != null && !thisinput.isEmpty() && End( thisinput ) ) { // 程式結束
      return false;
    } // if

    while ( thisinput != null && !breakkk ) {
      String oldInput = thisinput;
      if ( thisinput != null && !thisinput.isEmpty() && End( thisinput ) ) { // 程式結束
        return false;
      } // if

      if ( thisinput != null && !thisinput.isEmpty() && Iswhitespace( thisinput.charAt( 0 ) ) ) { // 跳過空白
        thisinput = Skipwhitespace( thisinput );
      } // if

      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) ) {
        if ( thisinput.charAt( 0 ) == '{' )  braces++;
        if ( thisinput.charAt( 0 ) == '}' )  braces--;
        thisinput = Whichtokentype( thisinput );
        if ( oldInput.startsWith( thisinput ) && thisinput != null 
             && ( thisinput.equals( ";" ) || thisinput.equals( "}" ) ) ) {
          if ( mALLToken.size() > 0 ) {
            checker.Setmtokens( mALLToken );
            boolean isValid = checker.Check();
            if ( !isValid ) {
              sLine = 0;
              braces = 0;
              sifcout = 0;
              mtempnewinput = null;
              Grammarcheck.sfunvariableMap.Clear();
              return false;
            } // if

            else if ( isValid && braces != 0
                      && mtempnewinput != null && mtempnewinput != "" ) {
              thisinput = mtempnewinput;
              mtempnewinput = null;
            } // else if

            else if ( isValid && braces != 0 ) {
              thisinput = Getline();
              while ( thisinput != null && ( thisinput.equals( "" ) || Islineallspace( thisinput ) ) ) {
                sLine++;
                thisinput = Getline();
              } // while

              sLine++;
              if ( thisinput == null ) breakkk = true;
              else oldInput = null;
            } // else if
            
            else if ( isValid && sifcout != 0 ) {
              if ( mtempnewinput != null && mtempnewinput != "" ) {
                thisinput = mtempnewinput;
                mtempnewinput = null;
              } // if
              else {
                thisinput = Getline();
                if ( thisinput != null && !thisinput.isEmpty() && Iswhitespace( thisinput.charAt( 0 ) ) ) {
                  thisinput = Skipwhitespace( thisinput );
                } // if

                sLine++;
              } // else

              if ( thisinput == null ) breakkk = true;
              if ( !thisinput.startsWith( "else" ) ) {
                mtempnewinput = thisinput;
                breakkk = true;
                thisinput = null;
              } // if
              
            } // else if

            else thisinput = null;
          } // if

          if ( thisinput == null && braces == 0 ) breakkk = true;
        } // if
      } // if

      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) )
        thisinput = Isdone( thisinput );
      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) )
        thisinput = Iscincout( thisinput );
      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) )
        thisinput = Isstring( thisinput );
      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) )
        thisinput = Ischar( thisinput );
      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) )
        thisinput = Isboolean( thisinput );
      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) )
        thisinput = Whichvariabletype( thisinput );
      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) )
        thisinput = WhichFunction( thisinput );
      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) ) 
        thisinput = Identifier( thisinput );
      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) )
        thisinput = IntorFloat( thisinput );
      if ( thisinput != null && !thisinput.isEmpty() && thisinput.equals( oldInput ) && !breakkk ) {
        Token temp = new Token();
        temp.mString += thisinput;
        temp.mType = TokenType.UNRECOGNIZEDTOKEN;
        mALLToken.add( temp );
        System.out.print( "Line " + sLine + " : " ); 
        System.out.println( "Unrecognized token with first char : '" + thisinput.charAt( 0 ) + "'" );
        return false;
      } // if

      if ( breakkk == false && ( thisinput == "" || thisinput == null || thisinput.isEmpty() ) ) {
        checker.Setmtokens( mALLToken );
        boolean isValid = checker.Check();
        if ( isValid ) {
          oldInput = "";
          thisinput = Getline();
          while ( thisinput != null && ( thisinput.equals( "" ) || Islineallspace( thisinput ) ) ) {
            sLine++;
            thisinput = Getline();
          } // while

          sLine++;
        } // if
        else {
          sLine = 0;
          braces = 0;
          sifcout = 0;
          return false;
        } // else
      } // if
      
    } // while
    
    return true;
  } // ALLTokenGetter()

  boolean Done() {
    String endline = "";
    for ( int i = 0 ; i < mAllline.size() ; i++ ) {
      String line = mAllline.get( i );
      line = Skipallspace( line );
      if ( line.contains( "Done();" ) || endline.contains( "Done();" ) ) return true;
      else if ( line.contains( "Done" ) || line.contains( "Done(" )  || line.contains( "Done()" ) ) {
        endline += line;
        i++;
        if ( i < mAllline.size() ) {
          line = mAllline.get( i );
          line = Skipallspace( line );
          boolean breakkk = false;
          while ( !breakkk && ( Islineallspace( line ) || line.equals( "" ) ) ) {
            i++;
            if ( i < mAllline.size() ) {
              line = mAllline.get( i );
              line = Skipallspace( line );
            } // if
            else breakkk = true;
          } // while
            
          if ( line.startsWith( ";" ) || line.equals( "(" ) || line.equals( ")" ) || line.equals( "()" ) 
               || line.equals( ");" ) || line.equals( "();" ) ) {
            endline += line;
            i++;
            if ( endline.contains( "Done();" ) ) return true;
            else if ( i < mAllline.size() ) {
              line = mAllline.get( i );
              line = Skipallspace( line );
              while ( !breakkk && ( Islineallspace( line ) || line.equals( "" ) ) ) {
                i++;
                if ( i < mAllline.size() ) {
                  line = mAllline.get( i );
                  line = Skipallspace( line );
                } // if
                else breakkk = true;
              } // while

              if ( line.equals( ")" ) || line.startsWith( ";" ) || line.equals( ");" ) ) {
                endline += line;
                i++;
                if ( endline.contains( "Done();" ) ) return true;
                else if ( i < mAllline.size() ) {
                  line = mAllline.get( i );
                  line = Skipallspace( line );
                  while ( !breakkk && ( Islineallspace( line ) || line.equals( "" ) ) ) {
                    i++;
                    if ( i < mAllline.size() ) {
                      line = mAllline.get( i );
                      line = Skipallspace( line );
                    } // if
                    else breakkk = true;
                  } // while
    
                  if ( line.startsWith( ";" ) ) {
                    endline += line;
                    if ( endline.contains( "Done();" ) ) return true;
                  } // if
                } // else if
              } // if
            } // else if
          } // if
        } // if
      } // else if
    } // for

    return false;
  } // Done()

  boolean Islineallspace( String line ) {
    for ( int i = 0 ; i < line.length() ; i++ ) {
      if ( !Iswhitespace( line.charAt( i ) ) ) return false;
    } // for

    return true;
  } // Islineallspace()

  void Getallline() {
    Scanner scanner = new Scanner( System.in );
    String line = scanner.nextLine();
    mAllline.add( line );
    if ( line.equals( "2" ) ) ;
    boolean breakkk = false;
    while ( !breakkk && scanner.hasNextLine() ) {
      line = scanner.nextLine();
      for ( int i = 0; line != null && i + 1 < line.length() ; i++ ) {
        if ( line != null && !line.equals( "" ) && line.charAt( i ) == '/' ) {
          if ( line.charAt( i + 1 ) == '/' ) {
            line = line.substring( 0, i );
          } // if
        } // if
        
      } // for

      if ( line != null ) {
        mAllline.add( line );
        if ( Done() ) breakkk = true;

      } // if

    } // while

    scanner.close();
  } // Getallline()

  String Getline() {
    String line = null;
    if ( !mAllline.isEmpty() ) {
      line = mAllline.get( 0 );
      mAllline.remove( 0 );
    } // if

    return line;
  } // Getline()

} // class Token

class Grammarcheck{
  public static MyFunMap sFUNCTIONMAP = new MyFunMap();
  public static MyMap sfunvariableMap = new MyMap();
  public static MyMap svariableMap = new MyMap();
  public static MyMap sintidentMap = new MyMap();
  public static MyMap sfloatidentMap = new MyMap();
  public static MyMap scharidentMap = new MyMap();
  public static MyMap sbooleanidentMap = new MyMap();
  public static MyMap sstringidentMap = new MyMap();
  public static int sdefinitionorstatement = 0;
  public static boolean sisfunction = false;
  String mFunctionName = null;
  private Vector<Token> mtokens;
  private int mcurrentIndex = 0;
  private Token merrorToken = null;
  Grammarcheck( Vector<Token> ALLToken ) {
    this.mtokens = ALLToken;
  } // Grammarcheck()

  public void Setmtokens( Vector<Token> ALLToken ) {
    this.mtokens = ALLToken;
  } // Setmtokens()

  private Token Checkerror( Token currenttoken ) {
    Token token = new Token();

    if ( currenttoken.mType == TokenType.UNRECOGNIZEDTOKEN ) {
      token = currenttoken;
    } // if

    else if ( currenttoken.mType == TokenType.UUNDEFINDEDIDENT ) {
      token = currenttoken;
    } // else if

    else {
      token.mString = currenttoken.mString;
      token.mType = TokenType.UNEXPECTEDTOKEN;
    } // else

    return token;
  } // Checkerror()
  
  Vector<String> Sortname( Vector<String> name ) {
    for ( int i = 0 ; i < name.size() ; i++ ) {
      for ( int j = i + 1 ; j < name.size() ; j++ ) {
        if ( name.get( i ).compareTo( name.get( j ) ) > 0 ) {
          String temp = name.get( i );
          name.set( i, name.get( j ) );
          name.set( j, temp );
        } // if
      } // for
    } // for

    return name;
  } // Sortname()

  void ListAllFunctions() {
    Vector<String> name = new Vector<String>();
    for ( int i = 0 ; i < sFUNCTIONMAP.GetKeys().size() ; i++ ) {
      name.add( String.valueOf( sFUNCTIONMAP.GetKeys().get( i ) ) );
    } // for

    name = Sortname( name );
    for ( int i = 0 ; i < name.size() ; i++ ) {
      System.out.println( name.get( i ) + "()" );
    } // for
  } // ListAllFunctions()

  void ListAllVariables() {
    Vector<String> name = new Vector<String>();
    for ( int i = 0 ; i < sintidentMap.GetKeys().size() ; i++ ) {
      name.add( String.valueOf( sintidentMap.GetKeys().get( i ) ) );
    } // for

    for ( int i = 0 ; i < sfloatidentMap.GetKeys().size() ; i++ ) {
      name.add( String.valueOf( sfloatidentMap.GetKeys().get( i ) ) );
    } // for

    for ( int i = 0 ; i < scharidentMap.GetKeys().size() ; i++ ) {
      name.add( String.valueOf( scharidentMap.GetKeys().get( i ) ) );
    } // for

    for ( int i = 0 ; i < sbooleanidentMap.GetKeys().size() ; i++ ) {
      name.add( String.valueOf( sbooleanidentMap.GetKeys().get( i ) ) );
    } // for

    for ( int i = 0 ; i < sstringidentMap.GetKeys().size() ; i++ ) {
      name.add( String.valueOf( sstringidentMap.GetKeys().get( i ) ) );
    } // for

    name = Sortname( name );
    for ( int i = 0 ; i < name.size() ; i++ ) {
      System.out.println( name.get( i ) );
    } // for
  } // ListAllVariables()

  void ListFunction( String name ) {
    Function function = sFUNCTIONMAP.Get( name );
    if ( function == null ) {
      System.out.println( "Undefined identifier : '" + name + "'"  );
      return;
    } // if

    int n = 0; // 空格數
    for ( int i = 0 ; i <= function.GetCodeLinesSize() ; i++ ) {
      String all = function.GetCodeLines( i );
      if ( all.contains( "}" ) && n != 0 ) n = n - 2;
      for ( int j = 0 ; j < n ; j++ ) {
        System.out.print( " " );
      } // for

      if ( all.equals( ";" ) ) {
        int whitespace = n;
        for ( int j = 0 ; j < whitespace ; j++ ) {
          System.out.print( " " );
        } // for
      } // if

      System.out.println( all );
      if ( all.contains( "{" ) ) n = n + 2;
    } // for

    System.out.println( "Statement executed ..." );
  } // ListFunction()

  void ListVariable( String name ) {
    if ( sintidentMap.ContainsKey( name ) ) 
      System.out.println( "int " + name + " ;" );
    else if ( sfloatidentMap.ContainsKey( name ) )
      System.out.println( "float " + name + " ;" );
    else if ( scharidentMap.ContainsKey( name ) ) {
      String charname = scharidentMap.Get( name );
      System.out.println( "char " + charname + " ;" );
    } // else if
    else if ( sstringidentMap.ContainsKey( name ) )
      System.out.println( "string " + name + " ;" );
    else if ( sbooleanidentMap.ContainsKey( name ) )
      System.out.println( "bool " + name + " ;" );
    else {
      System.out.println( "Undefined identifier : '" + name + "'"  );
      return;
    } // else
    
    System.out.println( "Statement executed ..." );
  } // ListVariable()

  void Defineidentifier() { // 定義變數
    int index = 0;
    boolean print = false;
    boolean breakkk = false;
    int typenum = 0;
    while ( !breakkk && index < mtokens.size() && mtokens.get( index ).mType != TokenType.SEMICOLON ) {
      Token currentToken = mtokens.get( index );
      if ( !sisfunction && ( currentToken.mType == VariableType.INT || typenum == 1 ) ) {
        if ( typenum == 0 ) index++;
        if ( svariableMap.ContainsKey( mtokens.get( index ).mString ) ) {
          System.out.println( "New definition of " + mtokens.get( index ).mString + " entered ..." );
          print = true;
        } // if

        svariableMap.Put( mtokens.get( index ).mString, VariableType.INT );
        sintidentMap.Put( mtokens.get( index ).mString, "0" );
        typenum = 1;
      } // if

      else if ( !sisfunction && ( currentToken.mType == VariableType.FLOAT || typenum == 2 ) ) {
        if ( typenum == 0 ) index++;
        if ( svariableMap.ContainsKey( mtokens.get( index ).mString ) ) {
          System.out.println( "New definition of " + mtokens.get( index ).mString + " entered ..." );
          print = true;
        } // if

        svariableMap.Put( mtokens.get( index ).mString, VariableType.FLOAT );
        sfloatidentMap.Put( mtokens.get( index ).mString, "0.0" );
        typenum = 2;
      } // else if

      else if ( !sisfunction && ( currentToken.mType == VariableType.CHAR || typenum == 3 ) ) {
        if ( typenum == 0 ) index++;
        String oriname = mtokens.get( index ).mString;
        String charname = mtokens.get( index ).mString;
        if ( index + 1 < mtokens.size() && mtokens.get( index + 1 ).mType == TokenType.OPEN_BRACKET ) {
          charname = charname +  mtokens.get( index + 1 ).mString + " ";
          charname = charname + mtokens.get( index + 2 ).mString + " ";
          charname = charname + mtokens.get( index + 3 ).mString;
          index += 3;
        } // if

        if ( svariableMap.ContainsKey( oriname ) ) {
          System.out.println( "New definition of " + oriname + " entered ..." );
          print = true;
        } // if
        else {
          System.out.println( "Definition of " + oriname + " entered ..." );
          print = true;
        } // else

        svariableMap.Put( oriname, VariableType.CHAR );
        scharidentMap.Put( oriname, charname );
        typenum = 3;
      } // else if

      else if ( !sisfunction && ( currentToken.mType == VariableType.BOOLEAN || typenum == 4 ) ) {
        if ( typenum == 0 ) index++;
        if ( svariableMap.ContainsKey( mtokens.get( index ).mString ) ) {
          System.out.println( "New definition of " + mtokens.get( index ).mString + " entered ..." );
          print = true;
        } // if

        svariableMap.Put( mtokens.get( index ).mString, VariableType.BOOLEAN );
        sbooleanidentMap.Put( mtokens.get( index ).mString, "false" );
        typenum = 4;
      } // else if

      else if ( !sisfunction &&  ( currentToken.mType == VariableType.STRING || typenum == 5 ) ) {
        if ( typenum == 0 ) index++;
        if ( svariableMap.ContainsKey( mtokens.get( index ).mString ) ) {
          System.out.println( "New definition of " + mtokens.get( index ).mString + " entered ..." );
          print = true;
        } // if

        svariableMap.Put( mtokens.get( index ).mString, VariableType.STRING );
        sstringidentMap.Put( mtokens.get( index ).mString, "" );
        typenum = 5;
      } // else if

      else if ( sisfunction || currentToken.mType == VariableType.VOID ) {
        index++;
        if ( sFUNCTIONMAP.ContainsKey( mtokens.get( index ).mString ) ) {
          System.out.println( "New definition of " + mtokens.get( index ).mString + "() entered ..." );
          print = true;
        } // if

        else {
          System.out.println( "Definition of " + mtokens.get( index ).mString + "() entered ..." );
          print = true; 
        } // else

        mFunctionName = mtokens.get( index ).mString;
        Functioninside( mFunctionName );
      } // else if

      else breakkk = true;
      if ( !print )
        System.out.println( "Definition of " + mtokens.get( index ).mString + " entered ..." );
      print = false;
      index++;
      if ( index < mtokens.size() && mtokens.get( index ).mType != TokenType.COMMA ) breakkk = true;
      else index++;
    } // while
  } // Defineidentifier()

  void Functioninside( String FunctionName ) { // 設定function內容
    Function function = new Function(); // 建立function物件
    Token currentToken = null;
    String line = "";
    for ( int i = 0 ; i < mtokens.size() ; i++ ) {
      currentToken = mtokens.get( i );
      if ( currentToken.mType == TokenType.OPEN_BRACE || currentToken.mType == TokenType.CLOSE_BRACE 
           || currentToken.mType == TokenType.SEMICOLON ) {
        line += currentToken.mString;
        function.AddLine( line, 0 );
        line = "";
      } // if
      
      else if ( currentToken.mType == TokenType.IDENTIFIER
                && i + 1 < mtokens.size() 
                && ( mtokens.get( i + 1 ).mType == TokenType.OPEN_PAREN 
                     || mtokens.get( i + 1 ).mType == TokenType.OPEN_BRACKET
                     || mtokens.get( i + 1 ).mType == TokenType.PP
                     || mtokens.get( i + 1 ).mType == TokenType.MM ) ) {
        line += currentToken.mString;
      } // else if
      else if ( line.contains( "if" ) && currentToken.mType == TokenType.CLOSE_PAREN
                && i + 1 < mtokens.size()
                && mtokens.get( i + 1 ).mType == TokenType.SEMICOLON ) {
        line += currentToken.mString;
        function.AddLine( line, 0 );
        line = "";
      } // else if
      else
        line += currentToken.mString + " "; // 將token加入line
    } // for

    sFUNCTIONMAP.Put( FunctionName, function );
  } // Functioninside()

  void Checkidentifier() {
    int index = 0;
    boolean print = false;
    Token currentToken = mtokens.get( index );
    if ( currentToken.mType == TokenType.IDENTIFIER ) {
      if ( svariableMap.ContainsKey( currentToken.mString ) 
           || sFUNCTIONMAP.ContainsKey( currentToken.mString ) ) {
        if ( svariableMap.Get( currentToken.mString ) == VariableType.INT ) {
          if ( mtokens.get( index + 1 ).mType == TokenType.ASSIGN ) {
            if ( mtokens.get( index + 2 ).mType == TokenType.CONSTANT ) {
              sintidentMap.Put( currentToken.mString, mtokens.get( index + 2 ).mString );
            } // if
          } // if
        } // if

        else if ( svariableMap.Get( currentToken.mString ) == VariableType.FLOAT ) {
          if ( mtokens.get( index + 1 ).mType == TokenType.ASSIGN ) {
            if ( mtokens.get( index + 2 ).mType == TokenType.CONSTANT ) {
              sfloatidentMap.Put( currentToken.mString, mtokens.get( index + 2 ).mString );
            } // if
          } // if
        } // else if

        else if ( svariableMap.Get( currentToken.mString ) == VariableType.CHAR ) {
          if ( mtokens.get( index + 1 ).mType == TokenType.ASSIGN ) {
            if ( mtokens.get( index + 2 ).mType == TokenType.CONSTANT ) {
              scharidentMap.Put( currentToken.mString, mtokens.get( index + 2 ).mString );
            } // if
          } // if
        } // else if

        else if ( svariableMap.Get( currentToken.mString ) == VariableType.BOOLEAN ) {
          if ( mtokens.get( index + 1 ).mType == TokenType.ASSIGN ) {
            if ( mtokens.get( index + 2 ).mType == TokenType.CONSTANT ) {
              if ( mtokens.get( index + 2 ).mString.equals( "true" ) ) {
                sbooleanidentMap.Put( currentToken.mString, "true" );
              } // if
              else if ( mtokens.get( index + 2 ).mString.equals( "false" ) ) {
                sbooleanidentMap.Put( currentToken.mString, "false" );
              } // else if
            } // if
          } // if
        } // else if
        
        else if ( svariableMap.Get( currentToken.mString ) == VariableType.STRING ) {
          if ( mtokens.get( index + 1 ).mType == TokenType.ASSIGN ) {
            if ( mtokens.get( index + 2 ).mType == TokenType.CONSTANT ) {
              sstringidentMap.Put( currentToken.mString, mtokens.get( index + 2 ).mString );
            } // if
          } // if
        } // else if
      } // if

      else {
        System.out.print( "Line " + Token.sLine + " : " ) ;
        System.out.println( "Undefined identifier : '" + currentToken.mString + "'" );
        print = true;
      } // else

    } // if
    
    else if ( currentToken.mType == FunctionType.LAF ) {
      ListAllFunctions();
      System.out.println( "Statement executed ..." );
      print = true;
    } // if

    else if ( currentToken.mType == FunctionType.LAV ) {
      ListAllVariables();
      System.out.println( "Statement executed ..." );
      print = true;
    } // else if

    else if ( currentToken.mType == FunctionType.LF ) {
      int start = currentToken.mString.indexOf( "\"" ) + 1;
      int end = currentToken.mString.lastIndexOf( "\"" );
      String functionName = "";
      if ( start != -1 && end != -1 && start < end ) {
        functionName = currentToken.mString.substring( start, end );
      } // if

      ListFunction( functionName );
      print = true;
    } // else if

    else if ( currentToken.mType == FunctionType.LV ) {
      int start = currentToken.mString.indexOf( "\"" ) + 1;
      int end = currentToken.mString.lastIndexOf( "\"" );
      String variablename = "";
      if ( start != -1 && end != -1 && start < end ) {
        variablename = currentToken.mString.substring( start, end );
      } // if

      ListVariable( variablename );
      print = true;
    } // else if

    if ( !print )
      System.out.println( "Statement executed ..." );
  } // Checkidentifier()

  boolean User_input() {
    mcurrentIndex = 0;
    sisfunction = false;
    boolean breakkk = false;
    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return false;
    } // if

    
    Token currentToken = mtokens.get( mcurrentIndex );
    if ( currentToken.mType == FunctionType.LAF || currentToken.mType == FunctionType.LAV 
         || currentToken.mType == FunctionType.LF || currentToken.mType == FunctionType.LV ) {
      sdefinitionorstatement = 2;
      return true;
    } // if

    if ( Definition() ) {
      sdefinitionorstatement = 1;
      while ( !breakkk && mcurrentIndex < mtokens.size() ) {
        if ( Definition() ) {
          sdefinitionorstatement = 1;
        } // if
  
        else if ( Statement() ) {
          sdefinitionorstatement = 2;
        } // else if
        else {
          breakkk = true;
        } // else
      } // while

      return true;
    } // if

    else {
      mcurrentIndex = 0;
      if ( Statement() ) {
        sdefinitionorstatement = 2;
        while ( !breakkk && mcurrentIndex < mtokens.size() ) {
          if ( Definition() ) {
            sdefinitionorstatement = 1;
  
          } // if
    
          else if ( Statement() ) {
            sdefinitionorstatement = 2;
          } // else if
  
          else {
            breakkk = true;
          } // else
        } // while
  
        return true;
      } // if
    } // else
    
 
    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    if ( merrorToken == null ) 
      merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
    return false;

  } // User_input()

  boolean Definition() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == VariableType.VOID ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.IDENTIFIER ) {
            mFunctionName = currentToken.mString;
            mcurrentIndex++;
            if ( Function_definition_without_ID() ) {
              return true;
            } // if
          } // if
          else {
            merrorToken = Checkerror( currentToken );
          } // else
        } // if
      } // if

      else if ( Type_specifier() ) {
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.IDENTIFIER ) {
            mcurrentIndex++;
            if ( Function_definition_or_declarators() ) {
              return true;
            } // if

            else {
              boolean breakkk = false;
              while ( !breakkk && mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
                if ( currentToken.mType == TokenType.COMMA ) {
                  mcurrentIndex++;
                  if ( mcurrentIndex < mtokens.size() ) {
                    currentToken = mtokens.get( mcurrentIndex );
                    if ( currentToken.mType == TokenType.IDENTIFIER ) {
                      mcurrentIndex++;
                    } // if
                    else {
                      merrorToken = Checkerror( currentToken );
                      breakkk = true;
                    } // else
                  } // if
                  else breakkk = true;
                } // if
                else breakkk = true;
              } // while

              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
                if ( currentToken.mType == TokenType.SEMICOLON ) {
                  mcurrentIndex++;
                  return true;
                } // if
                else {
                  if ( merrorToken == null )
                    merrorToken = Checkerror( currentToken );
                } // else
              } // if
            } // else  
          } // if
          else {
            if ( merrorToken == null )
              merrorToken = Checkerror( currentToken );
          } // else
        } // if
      } // else if
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    return false;
  } // Definition()

  boolean Type_specifier() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == VariableType.INT || currentToken.mType == VariableType.FLOAT 
           || currentToken.mType == VariableType.CHAR || currentToken.mType == VariableType.BOOLEAN 
           || currentToken.mType == VariableType.STRING ) {
        mcurrentIndex++;
        return true;
      } // if
    } // if 

    return false;
  } // Type_specifier()

  boolean Function_definition_or_declarators() {
    if ( Function_definition_without_ID() ) return true;
    else if ( Rest_of_declarators() ) return true;
    return false;
  } // Function_definition_or_declarators()

  boolean Rest_of_declarators() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.OPEN_BRACKET ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.CONSTANT ) {
            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.CLOSE_BRACKET ) {
                mcurrentIndex++;
                if ( mcurrentIndex < mtokens.size() ) {
                  currentToken = mtokens.get( mcurrentIndex );
                  while ( currentToken.mType != TokenType.SEMICOLON ) {
                    if ( currentToken.mType == TokenType.COMMA ) {
                      mcurrentIndex++;
                      if ( mcurrentIndex < mtokens.size() ) {
                        currentToken = mtokens.get( mcurrentIndex );
                        if ( currentToken.mType == TokenType.IDENTIFIER ) {
                          mcurrentIndex++;
                          if ( mcurrentIndex < mtokens.size() ) {
                            currentToken = mtokens.get( mcurrentIndex );
                            if ( currentToken.mType == TokenType.OPEN_BRACKET ) {
                              mcurrentIndex++;
                              if ( mcurrentIndex < mtokens.size() ) {
                                currentToken = mtokens.get( mcurrentIndex );
                                if ( currentToken.mType == TokenType.CONSTANT ) {
                                  mcurrentIndex++;
                                  if ( mcurrentIndex < mtokens.size() ) {
                                    currentToken = mtokens.get( mcurrentIndex );
                                    if ( currentToken.mType == TokenType.CLOSE_BRACKET ) {
                                      mcurrentIndex++;
                                      if ( mcurrentIndex < mtokens.size() ) {
                                        currentToken = mtokens.get( mcurrentIndex );
                                      } // if
                                    } // if
                                  } // if
                                } // if
                              } // if
                            } // if
                          } // if
                        } // if
                      } // if
                    } // if
                  } // while

                  if ( currentToken.mType == TokenType.SEMICOLON ) {
                    mcurrentIndex++;
                    return true;
                  } // if
                } // if
              } // if
            } // if
            else {
              merrorToken = Checkerror( currentToken );
              return false;
            } // else
          } // if

          else {
            merrorToken = Checkerror( currentToken );
            return false;
          } // else
          
        } // if
      } // if
      
      else if ( currentToken.mType == TokenType.SEMICOLON ) {
        mcurrentIndex++;
        return true;
      } // else if
       
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    if ( merrorToken == null )
      merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
    return false;
  } // Rest_of_declarators()

  boolean Function_definition_without_ID() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.OPEN_PAREN ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == VariableType.VOID || Formal_parameter_list() ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                mcurrentIndex++;
                if ( mcurrentIndex < mtokens.size() ) {
                  if ( Compound_statement() ) return true;
                } // if
              } // if
              else {
                merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                return false;
              } // else
            } // if
          } // if

          else if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              if ( Compound_statement() ) return true;
            } // if
          } // else if
          else {
            merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
            return false;
          } // else
        } // if
      } // if
      else {
        merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
        return false;
      } // else
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    if ( merrorToken == null )
      merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
    return false;
  } // Function_definition_without_ID()

  boolean Formal_parameter_list() {
    if ( Type_specifier() ) {
      Token temp = mtokens.get( mcurrentIndex - 1 );
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        if ( currentToken.mType == TokenType.ANDD ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            currentToken = mtokens.get( mcurrentIndex );
          } // if
        } // if
      
        if ( currentToken.mType == TokenType.IDENTIFIER ) {
          sfunvariableMap.Put( currentToken.mString,  temp.mType );
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            currentToken = mtokens.get( mcurrentIndex );
            if ( currentToken.mType == TokenType.OPEN_BRACKET ) {
              mcurrentIndex++;
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
                if ( currentToken.mType == TokenType.CONSTANT ) {
                  mcurrentIndex++;
                  if ( mcurrentIndex < mtokens.size() ) {
                    currentToken = mtokens.get( mcurrentIndex );
                    if ( currentToken.mType == TokenType.CLOSE_BRACKET ) {
                      mcurrentIndex++;
                    } // if
                    else {
                      merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                      return false;
                    } // else
                  } // if
                } // if
                else {
                  merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                  return false;
                } // else
              } // if
            } // if

            boolean breakkk = false;
            while ( mcurrentIndex < mtokens.size() &&  breakkk == false ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.COMMA ) {
                mcurrentIndex++;
                if ( !Formal_parameter_list() ) {
                  return false;
                } // if
              } // if
              else {
                breakkk = true;
              } // else
            } // while
            
            return true;
          } // if
        } // if
      } // if
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
    return false;
  } // Formal_parameter_list()

  boolean Compound_statement() {
    boolean breakkk = false;
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.OPEN_BRACE ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          while ( !breakkk && mcurrentIndex < mtokens.size() 
                  && currentToken.mType != TokenType.CLOSE_BRACE ) {
            if ( Declaration() ) {
              if ( mcurrentIndex < mtokens.size() )
                currentToken = mtokens.get( mcurrentIndex );
            } // if

            else if ( Statement() ) {
              if ( mcurrentIndex < mtokens.size() )
                currentToken = mtokens.get( mcurrentIndex );
            } // else if

            else {
              breakkk = true;
            } // else
          } // while
        } // if

        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.CLOSE_BRACE ) {
            sisfunction = true;
            mcurrentIndex++;
            return true;
          } // if
          else {
            if ( merrorToken == null )
              merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
            return false;
          } // else
        } // if
      } // if

      else {
        if ( merrorToken == null )
          merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
      } // else
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    if ( merrorToken == null )
      merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
    return false;
  } // Compound_statement()

  boolean Declaration() {
    if ( Type_specifier() ) {
      Token temp = mtokens.get( mcurrentIndex - 1 );
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        if ( currentToken.mType == TokenType.IDENTIFIER ) {
          sfunvariableMap.Put( currentToken.mString, temp.mType );
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Rest_of_declarators() ) {
              return true;
            } // if
            else {
              boolean breakkk = false;
              while ( !breakkk && mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
                if ( currentToken.mType == TokenType.COMMA ) {
                  mcurrentIndex++;
                  if ( mcurrentIndex < mtokens.size() ) {
                    currentToken = mtokens.get( mcurrentIndex );
                    if ( currentToken.mType == TokenType.IDENTIFIER ) {
                      mcurrentIndex++;
                    } // if
                    else {
                      merrorToken = Checkerror( currentToken );
                      breakkk = true;
                    } // else
                  } // if
                  else breakkk = true;
                } // if
                else breakkk = true;
              } // while
  
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
                if ( currentToken.mType == TokenType.SEMICOLON ) {
                  mcurrentIndex++;
                  return true;
                } // if
                else {
                  if ( merrorToken == null )
                    merrorToken = Checkerror( currentToken );
                } // else
              } // if
            } // else  
          } // if
        } // if
        else {
          merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
        } // else
      } // if
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    return false;
  } // Declaration() 

  boolean Statement() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.SEMICOLON ) {
        mcurrentIndex++;
        return true;
      } // if
      else if ( Expression() ) {
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.SEMICOLON ) {
            mcurrentIndex++;
            return true;
          } // if
          else {
            merrorToken = Checkerror( currentToken );
            return false;
          } // else
        } // if
      } // else if
      else if ( currentToken.mType == TokenType.RETURN ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.SEMICOLON ) {
            mcurrentIndex++;
            return true;
          } // if
          else if ( Expression() ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.SEMICOLON ) {
                mcurrentIndex++;
                return true;
              } // if
            } // if
          } // else if
          else {
            if ( merrorToken == null )
              merrorToken = Checkerror( currentToken );
            return false;
          } // else
        } // if
      } // else if
      else if ( Compound_statement() ) {
        return true;
      } // else if
      else if ( currentToken.mType == TokenType.IF ) {
        merrorToken = null;
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.OPEN_PAREN ) {
            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              if ( Expression() ) {
                if ( mcurrentIndex < mtokens.size() ) {
                  currentToken = mtokens.get( mcurrentIndex );
                  if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                    mcurrentIndex++;
                    if ( mcurrentIndex < mtokens.size() ) {
                      if ( Statement() ) {
                        if ( mcurrentIndex < mtokens.size() ) {
                          currentToken = mtokens.get( mcurrentIndex );
                          if ( currentToken.mType == TokenType.ELSE ) {
                            mcurrentIndex++;
                            if ( mcurrentIndex < mtokens.size() ) {
                              if ( Statement() ) {
                                return true;
                              } // if
                              else {
                                if ( merrorToken == null )
                                  merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                                return false;
                              } // else
                            } // if
                          } // if
                          else {
                            mcurrentIndex--;
                            return true;
                          } // else
                        } // if
                      } // if
                      else {
                        if ( merrorToken == null )
                          merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                        return false;
                      } // else
                    } // if
                  } // if
                  else {
                    if ( merrorToken == null )
                      merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                    return false;
                  } // else
                } // if
              } // if
              else return false;
            } // if
          } // if 
          else {
            if ( merrorToken == null )
              merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
            return false;
          } // else
        } // if
      } // else if

      else if ( currentToken.mType == TokenType.WHILE ) {
        merrorToken = null;
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.OPEN_PAREN ) {
            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              if ( Expression() ) {
                if ( mcurrentIndex < mtokens.size() ) {
                  currentToken = mtokens.get( mcurrentIndex );
                  if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                    mcurrentIndex++;
                    if ( mcurrentIndex < mtokens.size() ) {
                      if ( Statement() ) {
                        return true;
                      } // if
                      else return false;
                    } // if
                  } // if
                  else {
                    if ( merrorToken == null )
                      merrorToken = Checkerror( currentToken );
                    return false;
                  } // else
                } // if
              } // if
              else return false;
            } // if
          } // if
          else {
            if ( merrorToken == null )
              merrorToken = Checkerror( currentToken );
            return false;
          } // else
        } // if
      } // else if
      else if ( currentToken.mType == TokenType.DO ) {
        merrorToken = null;
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Statement() ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.WHILE ) {
                mcurrentIndex++;
                if ( mcurrentIndex < mtokens.size() ) {
                  currentToken = mtokens.get( mcurrentIndex );
                  if ( currentToken.mType == TokenType.OPEN_PAREN ) {
                    mcurrentIndex++;
                    if ( mcurrentIndex < mtokens.size() ) {
                      if ( Expression() ) {
                        if ( mcurrentIndex < mtokens.size() ) {
                          currentToken = mtokens.get( mcurrentIndex );
                          if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                            mcurrentIndex++;
                            if ( mcurrentIndex < mtokens.size() ) {
                              currentToken = mtokens.get( mcurrentIndex );
                              if ( currentToken.mType == TokenType.SEMICOLON ) {
                                mcurrentIndex++;
                                return true;
                              } // if
                            } // if
                          } // if
                          else {
                            merrorToken = Checkerror( currentToken );
                            return false;
                          } // else
                        } // if
                      } // if
                      else return false;
                    } // if
                  } // if
                  else {
                    merrorToken = Checkerror( currentToken );
                    return false;
                  } // else
                } // if
              } // if
              else {
                merrorToken = Checkerror( currentToken );
                return false;
              } // else
            } // if 
          } // if 
          else return false; 
        } // if
      } // else if
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    if ( merrorToken == null )
      merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
    return false;
  } // Statement()

  boolean Expression() {
    if ( Basic_expression() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( currentToken.mType == TokenType.COMMA ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Basic_expression() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Expression()

  boolean Basic_expression() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.IDENTIFIER ) {
        if ( !svariableMap.ContainsKey( currentToken.mString ) 
             && !sfunvariableMap.ContainsKey( currentToken.mString )
             && !sFUNCTIONMAP.ContainsKey( currentToken.mString ) ) {
          Token temp = new Token();
          temp.mString = currentToken.mString;
          temp.mType = TokenType.UUNDEFINDEDIDENT;
          merrorToken = Checkerror( temp );
          return false;
        } // if
        
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Rest_of_Identifier_started_basic_exp() ) return true;
        } // if
      } // if
      else if ( currentToken.mType == TokenType.PP || currentToken.mType == TokenType.MM ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.IDENTIFIER ) {
            if ( !svariableMap.ContainsKey( currentToken.mString ) 
                 && !sFUNCTIONMAP.ContainsKey( currentToken.mString ) ) {
              Token temp = new Token();
              temp.mString = currentToken.mString;
              temp.mType = TokenType.UUNDEFINDEDIDENT;
              merrorToken = Checkerror( temp );
              return false;
            } // if

            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              if ( Rest_of_PPMM_Identifier_started_basic_exp() ) return true;
            } // if
          } // if
          else merrorToken = Checkerror( currentToken );
        } // if
      } // else if
      else if ( Sign() ) {
        while ( Sign() ) {  
        } // while

        if ( Sign_unary_exp() ) {
          if ( Romce_and_romloe() ) return true;
        } // if
      } // else if 
      else if ( currentToken.mType == TokenType.OPEN_PAREN ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Expression() ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                mcurrentIndex++;
                if ( mcurrentIndex < mtokens.size() ) {
                  if ( Romce_and_romloe() ) return true;
                } // if
              } // if
            } // if
          } // if
        } // if
      } // else if
      else if ( currentToken.mType == TokenType.CONSTANT ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Romce_and_romloe() ) return true;
        } // if
      } // else if
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    return false;
  } // Basic_expression()

  boolean Rest_of_Identifier_started_basic_exp() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.OPEN_BRACKET ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Expression()  ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.CLOSE_BRACKET ) {
                mcurrentIndex++;
                if ( Assignment_operator() ) {
                  if ( mcurrentIndex < mtokens.size() ) {
                    if ( Basic_expression() ) return true;
                    else return false;
                  } // if
                } // if
                else if ( currentToken.mType == TokenType.PP || currentToken.mType == TokenType.MM ) {
                  mcurrentIndex++;
                  if ( mcurrentIndex < mtokens.size() ) {
                    if ( Romce_and_romloe() ) return true;
                    else return false;
                  } // if
                } // else if

                else if ( Romce_and_romloe() ) return true;
              } // if
              else {
                merrorToken = Checkerror( currentToken );
                return false;
              } // else
            } // if
          } // if
          else return false;
        } // if
      } // if

      else if ( Assignment_operator() ) {
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Basic_expression() ) return true;
          else return false;
        } // if
      } // if
      else if ( currentToken.mType == TokenType.PP || currentToken.mType == TokenType.MM ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Romce_and_romloe() ) return true;
          else return false;
        } // if
      } // else if
      else if ( currentToken.mType == TokenType.OPEN_PAREN ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Actual_parameter_list() ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                mcurrentIndex++;
                if ( mcurrentIndex < mtokens.size() ) {
                  if ( Romce_and_romloe() ) return true;
                } // if
              } // if
            } // if
          } // if
          else if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              if ( Romce_and_romloe() ) return true;
            } // if
          } // else if
          else {
            merrorToken = Checkerror( currentToken );
            return false;
          } // else
        } // if
      } // else if

      else if ( Romce_and_romloe() ) return true;
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    return false;
  } // Rest_of_Identifier_started_basic_exp()

  boolean Rest_of_PPMM_Identifier_started_basic_exp() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.OPEN_BRACKET ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Expression() ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.CLOSE_BRACKET ) {
                mcurrentIndex++;
              } // if
              else {
                merrorToken = Checkerror( currentToken );
                return false;
              } // else
            } // if
          } // if
          else return false;
        } // if
      } // if

      if ( Romce_and_romloe() ) return true;
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    return false;
  } // Rest_of_PPMM_Identifier_started_basic_exp()

  boolean Sign() {
    if ( mcurrentIndex >= 0 && mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.ADD 
           || currentToken.mType == TokenType.SUB 
           || currentToken.mType == TokenType.NOT ) {
        mcurrentIndex++;
        return true;
      } // if
    } // if

    return false;
  } // Sign()

  boolean Actual_parameter_list() {
    if ( Basic_expression() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.COMMA ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Basic_expression() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Actual_parameter_list()

  boolean Assignment_operator() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.ASSIGN || currentToken.mType == TokenType.TE
           || currentToken.mType == TokenType.DE || currentToken.mType == TokenType.RE 
           || currentToken.mType == TokenType.PE || currentToken.mType == TokenType.ME ) {
        mcurrentIndex++;
        return true;
      } // if
    } // if

    return false;
  } // Assignment_operator()

  boolean Romce_and_romloe() {
    if ( Rest_of_maybe_logical_OR_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        if ( currentToken.mType == TokenType.QUESTION ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Basic_expression() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
                if ( currentToken.mType == TokenType.COLON ) {
                  mcurrentIndex++;
                  if ( mcurrentIndex < mtokens.size() ) {
                    if ( Basic_expression() ) return true;
                    else return false;
                  } // if
                } // if
                else {
                  merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                  return false;
                } // else
              } // if
            } // if
            else return false;
          } // if
        } // if
      } // if

      return true;
    } // if

    return false;
  } // Romce_and_romloe()

  boolean Rest_of_maybe_logical_OR_exp() {
    if ( Rest_of_maybe_logical_AND_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.OR ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_logical_AND_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Rest_of_maybe_logical_OR_exp()

  boolean Maybe_logical_AND_exp() {
    if ( Maybe_bit_OR_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.AND ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_bit_OR_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if
    
    return false;
  } // Maybe_logical_AND_exp()

  boolean Rest_of_maybe_logical_AND_exp() {
    if ( Rest_of_maybe_bit_OR_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.AND ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_bit_OR_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Rest_of_maybe_logical_AND_exp()

  boolean Maybe_bit_OR_exp() {
    if ( Maybe_bit_ex_OR_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.ORR ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_bit_ex_OR_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Maybe_bit_OR_exp()

  boolean Rest_of_maybe_bit_OR_exp() {
    if ( Rest_of_maybe_bit_ex_OR_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.ORR ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_bit_ex_OR_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Rest_of_maybe_bit_OR_exp()

  boolean Maybe_bit_ex_OR_exp() {
    if ( Maybe_bit_AND_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.CARET ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_bit_AND_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Maybe_bit_ex_OR_exp()

  boolean Rest_of_maybe_bit_ex_OR_exp() {
    if ( Rest_of_maybe_bit_AND_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.CARET ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_bit_AND_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Rest_of_maybe_bit_ex_OR_exp()

  boolean Maybe_bit_AND_exp() {
    if ( Maybe_equality_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.ANDD ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_equality_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if
    
    return false;
  } // Maybe_bit_AND_exp()

  boolean Rest_of_maybe_bit_AND_exp() {
    if ( Rest_of_maybe_equality_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && currentToken.mType == TokenType.ANDD ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_equality_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Rest_of_maybe_bit_AND_exp()

  boolean Maybe_equality_exp() {
    if ( Maybe_relational_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() 
                && ( currentToken.mType == TokenType.EQ || currentToken.mType == TokenType.NEQ ) ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_relational_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Maybe_equality_exp()


  boolean Rest_of_maybe_equality_exp() {
    if ( Rest_of_maybe_relational_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() 
                && ( currentToken.mType == TokenType.EQ || currentToken.mType == TokenType.NEQ ) ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_relational_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Rest_of_maybe_equality_exp()

  boolean Maybe_relational_exp() {
    if ( Maybe_shift_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() 
                && ( currentToken.mType == TokenType.GT || currentToken.mType == TokenType.LT 
                     || currentToken.mType == TokenType.GE || currentToken.mType == TokenType.LE ) ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_shift_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Maybe_relational_exp()

  boolean Rest_of_maybe_relational_exp() {
    if ( Rest_of_maybe_shift_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() && ( currentToken.mType == TokenType.GT 
                                                    || currentToken.mType == TokenType.LT 
                                                    || currentToken.mType == TokenType.GE 
                                                    || currentToken.mType == TokenType.LE ) ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_shift_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Rest_of_maybe_relational_exp()

  boolean Maybe_shift_exp() {
    if ( Maybe_additive_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() 
                && ( currentToken.mType == TokenType.LS || currentToken.mType == TokenType.RS ) ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_additive_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if
    
    return false;
  } // Maybe_shift_exp()

  boolean Rest_of_maybe_shift_exp() {
    if ( Rest_of_maybe_additive_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() 
                && ( currentToken.mType == TokenType.LS || currentToken.mType == TokenType.RS ) ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_additive_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if

          else if ( mcurrentIndex > mtokens.size() - 1 ) {
            return true;
          } // else if
        } // while
      } // if

      return true;
    } // if
    
    return false;
  } // Rest_of_maybe_shift_exp()

  boolean Maybe_additive_exp() {
    if ( Maybe_mult_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() 
                && ( currentToken.mType == TokenType.ADD || currentToken.mType == TokenType.SUB ) ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_mult_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Maybe_additive_exp()

  boolean Rest_of_maybe_additive_exp() {
    if ( Rest_of_maybe_mult_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        Token currentToken = mtokens.get( mcurrentIndex );
        while ( mcurrentIndex < mtokens.size() 
                && ( currentToken.mType == TokenType.ADD || currentToken.mType == TokenType.SUB ) ) {
          mcurrentIndex++;
          if ( mcurrentIndex < mtokens.size() ) {
            if ( Maybe_mult_exp() ) {
              if ( mcurrentIndex < mtokens.size() ) {
                currentToken = mtokens.get( mcurrentIndex );
              } // if
            } // if
            else return false;
          } // if
        } // while
      } // if

      return true;
    } // if

    return false;
  } // Rest_of_maybe_additive_exp()

  boolean Maybe_mult_exp() {
    if ( Unary_exp() ) {
      if ( mcurrentIndex < mtokens.size() ) {
        if ( Rest_of_maybe_mult_exp() ) return true;
      } // if
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    return false;
  } // Maybe_mult_exp()

  boolean Rest_of_maybe_mult_exp() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      while ( mcurrentIndex < mtokens.size() && ( currentToken.mType == TokenType.MUL 
                                                  || currentToken.mType == TokenType.DIV 
                                                  || currentToken.mType == TokenType.MOD ) ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Unary_exp() ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
            } // if
          } // if
          else return false;
        } // if
      } // while
    } // if

    return true;
  } // Rest_of_maybe_mult_exp()

  boolean Unary_exp() {
    if ( Sign() ) {
      while ( Sign() ) {
      } // while

      if ( Sign_unary_exp() ) return true;
    } // if
    else if ( Unsign_unary_exp() ) return true;
    else if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.PP || currentToken.mType == TokenType.MM ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.IDENTIFIER ) {
            if ( !svariableMap.ContainsKey( currentToken.mString )
                 && !sFUNCTIONMAP.ContainsKey( currentToken.mString ) ) {
              Token temp = new Token();
              temp.mString = currentToken.mString;
              temp.mType = TokenType.UUNDEFINDEDIDENT;
              merrorToken = Checkerror( temp );
              return false;
            } // if

            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.OPEN_BRACKET ) {
                mcurrentIndex++;
                if ( mcurrentIndex < mtokens.size() ) {
                  if ( Expression() ) {
                    if ( mcurrentIndex < mtokens.size() ) {
                      currentToken = mtokens.get( mcurrentIndex );
                      if ( currentToken.mType == TokenType.CLOSE_BRACKET ) {
                        mcurrentIndex++;
                        return true;
                      } // if
                      else {
                        merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                        return false;
                      } // else
                    } // if
                  } // if
                  else return false;
                } // if
              } // if
              else return true;
            } // if
          } // if
          else merrorToken = Checkerror( currentToken );
        } // if
      } // if
      
    } // else if

    return false;
  } // Unary_exp()

  boolean Sign_unary_exp() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.IDENTIFIER ) {
        if ( !svariableMap.ContainsKey( currentToken.mString )
             && !sFUNCTIONMAP.ContainsKey( currentToken.mString ) ) {
          Token temp = new Token();
          temp.mString = currentToken.mString;
          temp.mType = TokenType.UUNDEFINDEDIDENT;
          merrorToken = Checkerror( temp );
          return false;
        } // if

        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.OPEN_BRACKET ) {
            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              if ( Expression() ) {
                if ( mcurrentIndex < mtokens.size() ) {
                  currentToken = mtokens.get( mcurrentIndex );
                  if ( currentToken.mType == TokenType.CLOSE_BRACKET ) {
                    mcurrentIndex++;
                    return true;
                  } // if
                  else {
                    merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                    return false;
                  } // else
                } // if
              } // if
              else return false;
            } // if
          } // if
          else if ( currentToken.mType == TokenType.OPEN_PAREN ) {
            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              if ( Actual_parameter_list() ) {
                if ( mcurrentIndex < mtokens.size() ) {
                  currentToken = mtokens.get( mcurrentIndex );
                  if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                    mcurrentIndex++;
                    return true;
                  } // if
                } // if
              } // if
              else if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                mcurrentIndex++;
                return true;
              } // else if
              else {
                merrorToken = Checkerror( currentToken );
                return false;
              } // else
            } // if
          } // else if
        } // if

        return true;
      } // if

      else if ( currentToken.mType == TokenType.CONSTANT ) {
        mcurrentIndex++;
        return true;
      } // else if

      else if ( currentToken.mType == TokenType.OPEN_PAREN ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Expression() ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                mcurrentIndex++;
                return true;
              } // if
              else {
                merrorToken = Checkerror( currentToken );
                return false;
              } // else
            } // if
          } // if
        } // if
      } // else if

      else merrorToken = Checkerror( currentToken );
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    return false;
  } // Sign_unary_exp()

  boolean Unsign_unary_exp() {
    if ( mcurrentIndex < mtokens.size() ) {
      Token currentToken = mtokens.get( mcurrentIndex );
      if ( currentToken.mType == TokenType.IDENTIFIER ) {
        if ( !svariableMap.ContainsKey( currentToken.mString ) 
             && !sfunvariableMap.ContainsKey( currentToken.mString )
             && !sFUNCTIONMAP.ContainsKey( currentToken.mString ) ) {
          Token temp = new Token();
          temp.mString = currentToken.mString;
          temp.mType = TokenType.UUNDEFINDEDIDENT;
          merrorToken = Checkerror( temp );
          return false;
        } // if

        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          currentToken = mtokens.get( mcurrentIndex );
          if ( currentToken.mType == TokenType.OPEN_BRACKET ) {
            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              if ( Expression() ) {
                if ( mcurrentIndex < mtokens.size() ) {
                  currentToken = mtokens.get( mcurrentIndex );
                  if ( currentToken.mType == TokenType.CLOSE_BRACKET ) {
                    mcurrentIndex++;
                    if ( mcurrentIndex < mtokens.size() ) {
                      currentToken = mtokens.get( mcurrentIndex );
                      if ( currentToken.mType == TokenType.PP || currentToken.mType == TokenType.MM ) {
                        mcurrentIndex++;
                        return true;
                      } // if
                    } // if

                    return true;
                  } // if
                  else {
                    merrorToken = Checkerror( mtokens.get( mcurrentIndex ) );
                    return false;
                  } // else
                } // if
              } // if
              else return false;
            } // if
          } // if
          else if ( currentToken.mType == TokenType.PP || currentToken.mType == TokenType.MM ) {
            mcurrentIndex++;
            return true;
          } // else if
          else if ( currentToken.mType == TokenType.OPEN_PAREN ) {
            mcurrentIndex++;
            if ( mcurrentIndex < mtokens.size() ) {
              if ( Actual_parameter_list() ) {
                if ( mcurrentIndex < mtokens.size() ) {
                  currentToken = mtokens.get( mcurrentIndex );
                  if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                    mcurrentIndex++;
                    return true;
                  } // if
                } // if
              } // if
              else if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                mcurrentIndex++;
                return true;
              } // else if
              else {
                merrorToken = Checkerror( currentToken );
                return false;
              } // else
            } // if
          } // else if
        } // if

        return true;
      } // if

      else if ( currentToken.mType == TokenType.CONSTANT ) {
        mcurrentIndex++;
        return true;
      } // else if

      else if ( currentToken.mType == TokenType.OPEN_PAREN ) {
        mcurrentIndex++;
        if ( mcurrentIndex < mtokens.size() ) {
          if ( Expression() ) {
            if ( mcurrentIndex < mtokens.size() ) {
              currentToken = mtokens.get( mcurrentIndex );
              if ( currentToken.mType == TokenType.CLOSE_PAREN ) {
                mcurrentIndex++;
                return true;
              } // if
              else {
                merrorToken = Checkerror( currentToken );
                return false;
              } // else
            } // if
          } // if
        } // if
      } // else if

      else merrorToken = Checkerror( currentToken );
    } // if

    if ( mcurrentIndex > mtokens.size() - 1 ) {
      return true;
    } // if

    return false;
  } // Unsign_unary_exp()

  public boolean Check() {
    mcurrentIndex = 0;
    merrorToken = null;
    boolean isValid = User_input();
    if ( !isValid && merrorToken != null ) {
      if ( merrorToken.mType == TokenType.UNRECOGNIZEDTOKEN ) {
        System.out.print( "Line " + Token.sLine + " : " ); 
        System.out.println( "unrecognized token : '" + merrorToken.mString.charAt( 0 ) + "'" );
      } // if
      else if ( merrorToken.mType == TokenType.UUNDEFINDEDIDENT ) {
        System.out.print( "Line " + Token.sLine + " : " );
        System.out.println( "undefined identifier : '" + merrorToken.mString + "'" );
      } // else if
      else if ( merrorToken.mType == TokenType.UNEXPECTEDTOKEN ) {
        System.out.print( "Line " + Token.sLine + " : " );
        System.out.println( "unexpected token : '" + merrorToken.mString + "'" );
      } // else if
    } // if

    return isValid;
  } // Check()
} // class Grammarcheck

class IInterpreter {
  public void Interpreter() {
    Grammarcheck checker = new Grammarcheck( new Vector<Token>() );
    Token token = new Token();
    Token.InitFUNCTIONMAP();
    Token.InitVARIABLESMAP();
    Token.InitTOKENTYPEMAP();
    boolean end = false;
    token.Getallline();
    String testnum = token.Getline();
    if ( testnum.equals( "2" ) ) ;
    String input = null ;
    System.out.println( "Our-C running ..." );
    while ( end == false ) {
      if ( token.mtempnewinput == null || token.mtempnewinput.equals( "" ) 
           || token.Islineallspace( token.mtempnewinput ) ) {
        if ( token.mtempnewinput != null 
             && ( token.mtempnewinput.equals( "" ) || token.Islineallspace( token.mtempnewinput ) ) ) {
          Token.sLine++;
          token.mtempnewinput = null; 
        } // if

        input = token.Getline();
        while ( input != null && ( token.Islineallspace( input ) ||  input.equals( "" ) ) )  {
          Token.sLine++;
          input = token.Getline();
        } // while

        Token.sLine++;
      } // if
      else {
        input = token.mtempnewinput;
        Token.sLine++;
      } // else

      if ( input != null && !input.equals( "" ) && !token.Islineallspace( input ) )  
        System.out.print( "> " ) ;
      if ( input != null ) {
        token.mALLToken.clear();
        if ( token.ALLTokenGetter( input ) ) {
          if ( !token.mALLToken.isEmpty() ) {
            checker.Setmtokens( token.mALLToken );
            boolean isValid = checker.Check();
            if ( isValid ) {
              if ( Grammarcheck.sdefinitionorstatement == 1 ) 
                checker.Defineidentifier();
              else if ( Grammarcheck.sdefinitionorstatement == 2 )
                checker.Checkidentifier();
            } // if

          } // if

          Token.sLine = 0;
        } // if
        else if ( !token.mALLToken.isEmpty() 
                  && token.mALLToken.get( 0 ).mType == FunctionType.DONE ) {
          System.out.println( "Our-C exited ..." ) ;
          end = true;
        } // else if
      } // if
    } // while
  } // Interpreter()

} // class IInterpreter

public class Main {
  public static void main( String[] args ) throws Exception {
    IInterpreter interpreter = new IInterpreter();
    interpreter.Interpreter();
  } // main()
} // class Main

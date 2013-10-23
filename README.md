===================================
Android Input Validator
===================================

Library that validate text of all android classes that extends TextView (EditText especially)
It's simply extendable by adding new annotations,validators and validation methods.

===================================
Example usage
===================================

        @NotEmpty
        private EditText mEditText

        private Button mButton;

        @Override
        public void onCreate(Bundle bundle){
            super.onCreate(bundle);
            setContentView(R.layout.activity_main);
            mEditText = (EditText)findViewById(R.id.activity_main_edittext);
            mButton = (Button)v.findViewById(R.id.activity_main_button);
            mButton.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                    Validator validator = new Validator();
                    validator.validate(MainActivity.this);
                  }
            });
        }

===================================
Annotations
===================================

        @Email or @Email("text to set")
        @NotEmpty or @NotEmpty("text to set")
        @Number  or @Number("text to set")
        @Regex(value = "answer when not match", regex = "regex");

===================================
Add your own annotation
===================================

One thing you have to do is:
* create annotation
* create validator
* add validator to Validators class the same way as the others are added.




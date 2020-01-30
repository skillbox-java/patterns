package decorator;

public class WashingMachine {

  public static void main(String[] args) {
    BasicWashingProgram program = new BasicWashingProgram();
    DoubleSpinningProgram spinningProgram =
        new DoubleSpinningProgram(program);
    BoilingWashingProgram boilingProgram =
        new BoilingWashingProgram(spinningProgram);
    boilingProgram.executeProgram();
  }
}
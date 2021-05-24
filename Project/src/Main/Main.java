package Main;

import Virus.acidNucleic;
import Virus.capsid;
import Virus.envelope.coronaVirus;
import Virus.envelope.ebolaVirus;
import Virus.envelope.envelope;
import Virus.envelope.hiv;
import Virus.nonenvelope.noroVirus;
import Virus.nonenvelope.polioVirus;
import Virus.nonenvelope.rhinoVirus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {
    public static noroVirus noro;
    public static hiv hivVirus;
    public static ebolaVirus ebola;
    public static polioVirus polio;
    public static rhinoVirus rhino;
    public static coronaVirus corona;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../GUI/mainmenu/FXML/intro.fxml")));
            primaryStage.setTitle("Virus");
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.DECORATED);
            Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void setup(){
        noroVirus noro1 = new noroVirus(-1,
                new acidNucleic("ARN"),
                new capsid("None"),
                "Constant Domain:\n"  +
                        "the constant domain is blue. Note the large gap between the shell and" +
                        "domain and that the Fab binds to the very top of the P domain." +
                        "Panel C is a stereo diagram of the pseudo atomic model of the 2D3/MNV complex." +
                        "The open and closed conformations of the P domain is shown in red and blue, respectively." +
                        "The heavy chain variable and the light variable domains are shown in yellow and brown, respectively." +
                        "Note that the CDR3 loop of the heavy chain fits into the cleft between the A’-B’ and E’-F’ loops in" +
                        "the open conformation but completely overlaps the E’-F’ loop in the closed conformation," +
                        " making it unlikely that 2D3 can bind to the closed conformation.",
                "Varibale Domainn:\n" +
                        "the Fab variable domain is cyan",
                "P Domain:\n" +
                        "The P domains dimerize to form protrusions on the capsid surface." +
                        "The P domain is subdivided into P1 and P2 subdomains, with the latter containing the binding" +
                        "sites for cellular receptors and neutralizing antibodies. There is increasing evidence "+
                        "that these viruses are extremely dynamic and this flexibility is critical for viral replication." +
                        "There are at least two modes of flexibility; the entire P domain relative to the shell and within the P domain itself",
                "S domain:\n" +
                        "The S domain forms a shell around the viral RNA genome.",
                "RNA:\n" +
                        "RNA as its genetic material of Virus",
                "Viruses in Norovirus are non-enveloped, with icosahedral geometries." +
                        "Capsid diameters vary widely, from 23 to 40 nm in diameter." +
                        "The larger capsids (38–40 nm) exhibit T=3 symmetry and are composed of 180 VP1 proteins." +
                        "Small capsids (23 nm) show T=1 symmetry, and are composed of 60 VP1 proteins." +
                        "The virus particles demonstrate an amorphous surface structure when visualized using electron microscopy.");


        hiv hivVirus1 = new hiv(-1,new acidNucleic("ARN"),
                new capsid("None"),
                new envelope("Lipid bilayer:\n" +
                        "The envelope glycoproteins (Envs) of HIV-1 are embedded in the cholesterol-rich lipid membrane of the virus. " +
                        "Chemical depletion of cholesterol from HIV-1 particles inactivates their infectivity." +
                        " We observed that diverse HIV-1 strains exhibit a range of sensitivities to such treatment. " +
                        "Differences in sensitivity to cholesterol depletion could not be explained by variation in Env" +
                        " components known to interact with cholesterol, including the cholesterol-recognition motif and " +
                        "cytoplasmic tail of gp41. Using antibody-binding assays, measurements of virus infectivity, and " +
                        "analyses of lipid membrane order, we found that depletion of cholesterol from HIV-1 particles " +
                        "decreases the conformational stability of Env. It enhances exposure of partially cryptic epitopes " +
                        "on the trimer and increases sensitivity to structure-perturbing treatments such as antibodies and " +
                        "cold denaturation. Substitutions in the cholesterol-interacting motif of gp41 induced similar effects" +
                        " as depletion of cholesterol. Surface-acting agents, which are incorporated into the virus lipid membrane," +
                        " caused similar effects as disruption of the Env-cholesterol interaction.\n"),
                "Glycoprotein GP120:\n" +
                        "Gp120 is coded by the HIV env gene, which is around 2.5 kb long and codes for around 850 amino " +
                        "acids. The primary env product is the protein gp160, which gets cleaved to gp120 " +
                        "(~480 amino acids) and gp41 (~345 amino acids) in the endoplasmatic reticulum by the cellular " +
                        "protease furin. The crystal structure of core gp120 shows an organization with an outer domain," +
                        " an inner domain with respect to its termini and a bridging sheet. Gp120 is anchored to the" +
                        " viral membrane, or envelope, via non-covalent bonds with the transmembrane glycoprotein, gp41. " +
                        "Three gp120s and gp41s combine in a trimer of heterodimers to form the envelope spike,[8] which" +
                        " mediates attachment to and entry into the host cell.\n",
                "Glycoprotein GP41:\n" +
                        "Gp41 also known as glycoprotein 41 is a subunit of the envelope protein complex of retroviruses" +
                        ", including human immunodeficiency virus (HIV). Gp41 is a transmembrane protein that contains " +
                        "several sites within its ectodomain that are required for infection of host cells. As a result " +
                        "of its importance in ",
                "Human Leukoctye Antigen Class 1:\n" +
                        "The rapid and extensive spread of the human immunodeficiency virus (HIV) epidemic provides a " +
                        "rare opportunity to witness host-pathogen co-evolution involving humans. A focal point is the" +
                        " interaction between genes encoding human leukocyte antigen (HLA) and those encoding HIV proteins. " +
                        "HLA molecules present fragments (epitopes) of HIV proteins on the surface of infected cells to " +
                        "enable immune recognition and killing by CD8(+) T cells; particular HLA molecules, " +
                        "such as HLA-B*57, HLA-B*27 and HLA-B*51, are more likely to mediate successful control of " +
                        "HIV infection. Mutation within these epitopes can allow viral escape from CD8(+) T-cell " +
                        "recognition. Here we analysed viral sequences and HLA alleles from >2,800 subjects, " +
                        "drawn from 9 distinct study cohorts spanning 5 continents. Initial analysis of the HLA-B*51-" +
                        "restricted epitope, TAFTIPSI (reverse transcriptase residues 128-135), showed a strong " +
                        "correlation between the frequency of the escape mutation I135X and HLA-B*51 prevalence in" +
                        " the 9 study cohorts (P = 0.0001).\n",
                "Human Leukoctye Antigen Class 2: \n" +
                        "Human leukocyte antigen (HLA) class II molecules are essential in antigen presentation to CD4 " +
                        "T cells for activation of B cells to produce antibodies. We genotyped the classical HLA-DRB1, " +
                        "DQB1, and DPB1 genes in 450 individuals from the placebo arm of the RV144 study to determine " +
                        "the background allele and haplotype frequencies of these genes in this cohort. High-resolution" +
                        " 4 and 6-digit class II HLA typing data was generated using sequencing-based methods." +
                        " The observed diversity for the HLA loci was 33 HLA-DRB1, 15 HLA-DQB1, and 26 HLA-DPB1 alleles. " +
                        "Common alleles with frequencies greater than 10%\n",
                "" +
                        "Integrase:\n" +
                        "Retroviral integrase (IN) is an enzyme produced by a retrovirus (such as HIV) that integrates—" +
                        "forms covalent links between—its genetic information into that of the host cell it infects." +
                        " Retroviral INs are not to be confused with phage integrases (recombinases), such as λ phage" +
                        " integrase, as discussed in site-specific recombination.HIV integrase is a 32 kDa protein produced " +
                        "from the C-terminal portion of the Pol gene product, and is an attractive target for new anti-HIV drugs.\n",
                "Nucleocapsid p24:\n" +
                        "One distinctive HIV antigen is a viral protein called p24, a structural protein that makes up " +
                        "most of the HIV viral core, or 'capsid'. High levels of p24 are present in the blood serum of" +
                        " newly infected individuals during the short period between infection and seroconversion, making " +
                        "p24 antigen assays useful in diagnosing primary HIV infection. Antibodies to p24 are produced " +
                        "during seroconversion, rendering p24 antigen undetectable after seroconversion in most cases. " +
                        "Therefore, p24 antigen assays are not reliable for diagnosing HIV infection after its very earliest stages.\n",
                "Protease:\n" +
                        "HIV-1 protease (PR) is a retroviral aspartyl protease (retropepsin), an enzyme involved with" +
                        " peptide bond hydrolysis in retroviruses, that is essential for the life-cycle of HIV," +
                        " the retrovirus that causes AIDS.Mature HIV protease exists as a 22 kDa homodimer, with each" +
                        " subunit made up of 99 amino acids. A single active site lies between the identical subunits " +
                        "and has the characteristic Asp-Thr-Gly (Asp25, Thr26 and Gly27) catalytic triad sequence common " +
                        "to aspartic proteases. As HIV-1 PR can only function as a dimer, the mature protease" +
                        " contains two Asp25 amino acids, one from each monomer, that act in conjunction with" +
                        " each other as the catalytic residues. Additionally, HIV protease has two molecular \"flaps\" " +
                        "which move a distance of up to 7 Å when the enzyme becomes associated with a substrate. " +
                        "This can be visualized with animations of the flaps opening and closing.\n",
                "RNA:\n" +
                        "Upon entry into the target cell, the viral RNA genome is converted (reversed) to double-stranded " +
                        "DNA by the reverse transcriptase enzyme that has been transported with the viral genome in viral " +
                        "particles. The generated viral DNA is then inserted into the cell nucleus and integrated into the " +
                        "cell's DNA by the viral integrase enzyme and host cell cofactors. Once integrated, the virus" +
                        " becomes latent, allowing the virus and its host cells to avoid detection by the immune system." +
                        " Alternatively, the virus can be replicated, producing viral RNA and protein genomes, and then" +
                        " packaged and released from the cell as new viral particles and initiate a continuing cycle of" +
                        " replication.\n",
                "Reverse Transccriptase:\n" +
                        "A reverse transcriptase (RT) is an enzyme used to generate complementary DNA (cDNA) from an RNA " +
                        "template, a process termed reverse transcription. Reverse transcriptases are used by certain " +
                        "viruses such as HIV and hepatitis B to replicate their genomes, by retrotransposon mobile genetic" +
                        " elements to proliferate within the host genome, and by eukaryotic cells to extend the telomeres" +
                        " at the ends of their linear chromosomes. Contrary to a widely held belief, the process does not " +
                        "violate the flows of genetic information as described by the classical central dogma, as transfers " +
                        "of information from RNA to DNA are explicitly held possible. Reverse-transcribing DNA viruses, " +
                        "such as the hepadnaviruses, can allow RNA to serve as a template in assembling and making DNA " +
                        "strands. HIV infects humans with the use of this enzyme. Without reverse transcriptase, " +
                        "the viral genome would not be able to incorporate into the host cell, resulting in failure to replicate.\n",
                "Matrix protein p17:\n" +
                        "The HIV-1 matrix protein p17 is a structural protein critically involved in most stages of the" +
                        " life cycle of the retrovirus. It participates in the early stages of virus replication as well" +
                        " as in RNA targeting to the plasma membrane, incorporation of the envelope into virions and " +
                        "particle assembly. Besides its well established functions, p17 acts as a viral cytokine that" +
                        " works on preactivated--but not on resting--human T cells promoting proliferation, " +
                        "proinflammatory cytokines release and HIV-1 replication after binding to a cellular receptor (p17R)." +
                        " Thus, p17 might play a key role in the complex network of host- and virus-derived stimulatory " +
                        "factors contributing to create a favourable environment for HIV-1 infection and replication." +
                        " Here, we present a brief overview of the functions played by the matrix protein p17 in the" +
                        " HIV-1 life cycle and summarize the current understanding of how p17 could contribute to the" +
                        " pathogenesis of HIV-1 disease.",
                " Protein p7,p9:\n" +
                        "Gag protein, p7 or p9, is termed the nucleocapsid protein, and is tightly associated with the RNA genome: it has been found to promote both RNA dimerization and encapsidation. The most C-terminal of the Gag proteins is p6; although its function is not known, mutants lacking this protein exhibit a defect in particle budding.\n");

        ebolaVirus ebola1 = new ebolaVirus(-1,new acidNucleic("ARN"),
                new capsid("NONE"),
                new envelope("Viral envelope:\n" +
                        "A viral envelope is the outermost layer of many types of viruses. It protects the genetic material" +
                        " in their life-cycle when traveling between host cells.\n"),
                "Glycoprotein:\n" +
                        "The EBOV glycoprotein (GP) is the only virally expressed protein on the virion surface and is" +
                        " critical for attachment to host cells and catalysis of membrane fusion. Hence, the EBOV GP is" +
                        " a critical component of vaccines as well as a target of neutralizingantibodies and inhibitors" +
                        " of attachment and fusion. The crystal structure of the Zaire ebolavirus GP in its trimeric," +
                        " prefusion conformation (3 GP1 plus 3 GP2) in complex with a neutralizing antibody fragment," +
                        " derived from a human survivor of the 1995 Kikwit outbreak, was recently determined. This is " +
                        "the first near-complete structure of any filovirus glycoprotein. The overall molecular " +
                        "architecture of the Zaire ebolavirus GP and its role in viral entry and membrane fusion are" +
                        " discussed in this article.\n",
                "Nucleoprotein:\n" +
                        "At 739 amino acids, the nucleoprotein (NP) of Ebola virus is the largest nucleoprotein of the " +
                        "nonsegmented negative-stranded RNA viruses, and like the NPs of other viruses, it plays a central " +
                        "role in virus replication. Huang et al. (Y. Huang, L. Xu, Y. Sun, and G. J. Nabel, Mol. Cell) " +
                        "previously demonstrated that NP, together with the minor matrix protein VP24 and polymerase" +
                        " cofactor VP35, is necessary and sufficient for the formation of nucleocapsid-like structures " +
                        "that are morphologically indistinguishable from those seen in Ebola virus-infected cells. They" +
                        " further showed that NP is O glycosylated and sialylated and that these modifications are " +
                        "important for interaction between NP and VP35. However, little is known about the" +
                        " structure-function relationship of Ebola virus NP. Here, we examined the glycosylation of" +
                        " Ebola virus NP and further investigated its properties by generating deletion mutants to " +
                        "define the region(s) involved in NP-NP interaction (self-assembly), in the formation of " +
                        "nucleocapsid-like structures, and in the replication of the viral genome. We were unable to" +
                        " identify the types of glycosylation and sialylation, although we did confirm that Ebola virus " +
                        "NP was glycosylated.\n",
                "RNA genoma:\n" +
                        "The EBOV genome is a single-stranded RNA, approximately 19,000 nucleotides long. It encodes seven " +
                        "structural proteins: nucleoprotein (NP), polymerase cofactor (VP35), (VP40), GP, transcription " +
                        "activator (VP30), VP24, and RNA-dependent RNA polymerase.\n",
                "VP40,VP24:\n" +
                        "the VP24 is a structural protein, that has the ability to internalize the cell nucleus, " +
                        "and known as a minor matrix protein and membrane‐associated protein. Then, the latest protein " +
                        "“VP40” is known as a viral matrix protein, and it is the most abundant protein in Ebola's viral structure.\n");
        ebola = ebola1;
        hivVirus = hivVirus1;
        noro = noro1;

    }


    public static void main(String[] args) {
        setup();
        launch(args);

    }
}

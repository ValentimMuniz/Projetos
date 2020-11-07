from tkinter import *
from tkinter import messagebox
from tkinter import filedialog
from PIL import ImageTk,Image
from collections import OrderedDict
from datetime import datetime
import json
import requests
import configparser
import csv
import sys
import os
import ipaddress



# Configuration File
config = configparser.ConfigParser()
config.read('config')
org_id = config['Umbrella']['OrgID']
mgmt_api_key = config['Umbrella']['ManagementAPIKey']
mgmt_api_secret = config['Umbrella']['ManagementAPISecret']

#Headers
header_internaldomain = {'Content-Type': 'application/json','Accept': 'application/json'}
header_sites = {'organizationID': '{}'.format(org_id)}
header_internalnet = {'organizationID': '{}'.format(org_id),'Content-Type': 'application/json','Accept': 'application/json'}

# management api url, usado para pegar o access token do reporting api
mgmt_url = 'https://management.api.umbrella.com/v1'


#############################  Funções para HTTP REQUESTS #############################

#Função para fazer GET dos Users existentes no Umbrella
def get_users_request(endpoint):
    r = requests.get(mgmt_url+endpoint, headers=header_sites, auth=(mgmt_api_key, mgmt_api_secret))
    body = json.loads(r.content)
    return body

#Função para fazer GET das Internal Networks existentes no Umbrella
def get_internaldomains_request(endpoint):
    r = requests.get(mgmt_url+endpoint, headers=header_internaldomain, auth=(mgmt_api_key, mgmt_api_secret))
    body = json.loads(r.content)
    return body

#Função para fazer POST e criar as Internal Networks
def post_internaldomains_request(endpoint, internaldomain):
    global code_access_token_domains
    # Build the POST data
    dataDomains = {
        "domain": internaldomain
    }
    r = requests.post(mgmt_url+endpoint, headers=header_internaldomain, auth=(mgmt_api_key, mgmt_api_secret), data=json.dumps(dataDomains))   
    code_access_token_domains = r.status_code
    if r.status_code == 401 or r.status_code == 403:
        return code_access_token_domains
    body = json.loads(r.content)
    return body
    
#Função para fazer GET dos sites
def get_sites_request(endpoint):
    r = requests.get(mgmt_url+endpoint, headers=header_sites, auth=(mgmt_api_key, mgmt_api_secret))
    body = json.loads(r.content)
    return body

def post_site_request(endpoint, sites):
    global code_access_token_site
    #Motando o data do POST
    dataSites = {
        "name": sites
    }
    
    r = requests.post(mgmt_url+endpoint, headers=header_sites, auth=(mgmt_api_key, mgmt_api_secret), data=json.dumps(dataSites))
    code_access_token_site = r.status_code
    if r.status_code == 401 or r.status_code == 403:
        return code_access_token_site
    body = json.loads(r.content)
    return body
    
#Função para fazer GET das Internal Networks existentes no Umbrella
def get_internalnetworks_request(endpoint):
    r = requests.get(mgmt_url+endpoint, headers=header_sites, auth=(mgmt_api_key, mgmt_api_secret))
    body = json.loads(r.content)
    return body

#Função para fazer POST e criar as Internal Networks
def post_internalnetworks_request(endpoint, internalnetworks):
    global code_access_token_net
    r = requests.post(mgmt_url+endpoint, headers=header_internalnet, auth=(mgmt_api_key, mgmt_api_secret), data=internalnetworks)   
    code_access_token_net = r.status_code
    if r.status_code == 401 or r.status_code == 403:
        return code_access_token_net
    body = json.loads(r.content)
    return body
############################# Fim de funções para HTTP REQUESTS #############################


def Quit(): root.destroy()


############################# Funções para validações do Internal Networks #############################
def checkValidIpNetwork(ip, name):
    try:
        ipaddress.IPv4Network(ip)
        return True
    except ValueError:
        f = open("wrongips.txt", "w")
        f.write("Ip/netmask inválido para o IPv4:" + ip + ", Internal Network Name:" + name)
        return False

# Função para remover duplicados no CSV 
def removeduplicate(it):
    seen = set()
    for x in it:
        t = tuple(x.items())
        if t not in seen:
            yield x
            seen.add(t)
############################# Fim de funções de validações do Internal Networks #############################


############################# Funções pra abrir Explorer para escolher CSV #############################
def browseInternalDomains(closing): 
    global internaldomainCSV
    if closing == False:
        filename = filedialog.askopenfilename(title = "Select a File", filetypes = (("CSV files", "*.csv*"), ("all files", "*.*")))
        internaldomainWindow.focus_set()
        internaldomainCSV = filename
    else:
        internaldomainCSV = ""

def browseSitesCSV(closing): 
    global SitesCSV
    if closing == False:
        filename = filedialog.askopenfilename(title = "Select a File", filetypes = (("CSV files", "*.csv*"), ("all files", "*.*")))
        SitesCSVWindow.focus_set()
        SitesCSV = filename
    else:
        SitesCSV = ""

def browseInternalNet(closing): 
    global internalNetCSV
    if closing == False:
        filename = filedialog.askopenfilename(title = "Select a File", filetypes = (("CSV files", "*.csv*"), ("all files", "*.*")))
        internalnetWindow.focus_set()
        internalNetCSV = filename
    else:
        internalNetCSV = ""
############################# Fim de funções pra abrir Explorer para escolher CSV #############################


############################# Funções pra quando fechar a janela zerar as variáveiis #############################
def on_closingConfig():
    configFileWindow.destroy()

def on_closingDomain():
    internaldomainWindow.destroy()
    browseInternalDomains(True)

def on_closingNet():
    internalnetWindow.destroy()
    browseInternalNet(True)

def on_closingSitesCSV():
    SitesCSVWindow.destroy()
    browseSitesCSV(True)
############################# Fim de fuções pra quando fechar a janela zerar as variáveiis #############################


############################# Janela Sites Manual #############################
def openMenuSiteManual():  
    global SiteManual 
    global siteTxt
    # Criar a Janela via Toplevel e setar parametros iniciais
    SiteManual = Toplevel(root) 
    SiteManual.title("Umbrella Create a Site") 
    SiteManual.wm_iconbitmap('favicon_cisco.ico')
    SiteManual.minsize(400,200)
    center(SiteManual)
    SiteManual.resizable(0,0)
    label = Label(SiteManual,text='Criar Site',font='Calibri 14 bold')
    label.grid(column=1,row=0,pady=6)

    label = Label(SiteManual,text='Site name', font='Calibri 10 bold')
    label.grid(column=0,row=1,padx=8, sticky='W')

    siteTxt = Text(SiteManual, width=25, height=1)
    siteTxt.grid(column=1,row=1,pady=2)
    siteTxt.focus_set()

    cadastrarBtn = Button(SiteManual, text = "Cadastrar Site", width=25, command = lambda: RegistrarNovoSite(siteTxt.get("1.0","end-1c")))
    cadastrarBtn.grid(column= 1, row = 4,pady=3)


def RegistrarNovoSite(siteName):
    if not siteName:
        messagebox.showinfo("Nome vazio", "Por favor, preencha o campo 'Site Name'", parent=SiteManual)
        siteTxt.focus_set()
    else:
        # variavel pra checkar se um site ja esta cadastrado
        cadastrado = False
        #fazer o get dos sites para pegar verificar se o nome que vc deu pro site já existe
        r_get_sites_check = get_sites_request('/organizations/{}/sites'.format(org_id))
        dump_sites_check = json.dumps(r_get_sites_check)
        sites_json_check = json.loads(dump_sites_check)

        for ja_cadastrado in sites_json_check:
            if ja_cadastrado['name'] == siteName.strip():
                cadastrado = True
                break
        if cadastrado == False:
            post_site_request('/organizations/{}/sites'.format(org_id), siteName.strip())
            if code_access_token_site == 200:
                messagebox.showinfo("Sucesso", "Site: " + siteName + " castrado com sucesso!!", parent=SiteManual)
                siteTxt.focus_set()
            elif code_access_token_site == 401 or code_access_token_site == 403:
                messagebox.showinfo("Não autorizado ou inválido", "Verifique o arquivo de configuração", parent=internalnetWindow)
        elif cadastrado == True:
            messagebox.showerror("Já cadastrado", "Site: " + siteName + " já cadastrado!!", parent=SiteManual)
            SiteManual.focus_set()
            siteTxt.focus_set()
            siteTxt.delete('1.0', END)
        


############################# Janela Configuration File #############################
def openMenuConfigurationFile():  
    # Variavel global poist tem uso em outras funções
    global configFileWindow 
    # Criar a Janela via Toplevel e setar parametros iniciais
    configFileWindow = Toplevel(root) 
    configFileWindow.title("Umbrella Internal Domains Register") 
    configFileWindow.wm_iconbitmap('favicon_cisco.ico')
    configFileWindow.minsize(445,100)
    center(configFileWindow)
    configFileWindow.resizable(0,0)

    file = open("config").read()
    t = Text(configFileWindow, width=55, height=5)
    t.pack()
    t.insert(0.0, file) 

    botao_salvar = Button(configFileWindow, text = "Salvar configuração", width=20, height=1, command= lambda: save_configfile(t.get("1.0",END)))
    botao_salvar.place(relx=.0, rely=.46)

    configFileWindow.protocol("WM_DELETE_WINDOW", on_closingConfig)

############################# Função para salvar o arquivo de configuração #############################
def save_configfile(self):
    f = open("config", "w")
    f.write(self)
    messagebox.showinfo("Sucesso", "Arquivo de configuração salvo com sucesso")
    configFileWindow.destroy()


############################# Janela Internal Networks #############################
def openMenuInternalNetworks():   
    # Variavel global poist tem uso em outras funções
    global internalnetWindow
    global idTxt
    # Criar a Janela via Toplevel e setar parametros iniciais
    internalnetWindow = Toplevel(root)   
    internalnetWindow.title("Umbrella Internal Networks Register") 
    internalnetWindow.wm_iconbitmap('favicon_cisco.ico')
    internalnetWindow.configure(bg='#0ea3da')
    internalnetWindow.minsize(600,700)
    center(internalnetWindow)
    internalnetWindow.resizable(0,0)
    
    r_get_sites = get_sites_request('/organizations/{}/sites'.format(org_id))
    dump_sites = json.dumps(r_get_sites)
    sites_json = json.loads(dump_sites)

    listasites = ""
    for sites in sites_json:
        listasites += "Site: " + sites['name'] + ", ID: " + str(sites['siteId']) + "\n"

    labelprinc = Label(internalnetWindow,text='Cadastrar Internal Networks',font='Calibri 15 bold', bg='#0ea3da')
    labelprinc.place(relx=.25, rely=.0)

    lablcsv = Label(internalnetWindow,text='Ecolher CSV ->', font='Calibri 13 bold', bg='#0ea3da')
    lablcsv.place(relx=.012, rely=.1)

    botao_csv = Button(internalnetWindow, text = "Explorar Arquivos", width=20, height=1, command= lambda: browseInternalNet(False))
    botao_csv.place(relx=.19, rely=.1)

    labelSite = Label(internalnetWindow,text='A qual site atribuir essas Internal Netwoks? (ID): ', font='Calibri 13 bold', bg='#0ea3da')
    labelSite.place(relx=.012, rely=.154)

    idTxt = Text(internalnetWindow, width=10, height=1)
    idTxt.place(relx=.58, rely=.16)

    
    botao_enviar = Button(internalnetWindow, text = "Enviar", width=20, height=1,borderwidth = '2', command=lambda: CadastrarInternalNet(idTxt.get("1.0","end-1c")))
    botao_enviar.place(relx=.012, rely=.24)

    lista=Text(internalnetWindow, width=40, height=29)
    lista.place(relx=.012, rely=.3)
    lista.insert(0.0, listasites)
    lista.config(state=DISABLED)    

    internalnetWindow.protocol("WM_DELETE_WINDOW", on_closingNet)

############################# Função para pegar o CSV de Internal Domains #############################    
def load_csvInternalNet():
    try:
        # Tentando abrir o arquivo especificado
        with open(internalNetCSV) as csv_file_domain:
            pass
    except:
        return "NotCSV"

############################# Ação do botão para cadastrar Internal Networks via CSV #############################
def CadastrarInternalNet(siteId):
    if not siteId:
        messagebox.showinfo("ID missing", "Por favor, preencha SiteId que vai atribuir", parent=internalnetWindow)
        idTxt.focus_set()
    else:
        # fazer o get das internal netwokrs para comparar com o vsv
        r_get_internalnet = get_internalnetworks_request('/organizations/{}/internalnetworks'.format(org_id))
        
        #Tratar json de r_get_internalnet
        dump_actual_internalnet = json.dumps(r_get_internalnet)
        act_internal_net = json.loads(dump_actual_internalnet)
        
        # remover do json act_internal_net o que nao importa comparar
        for element in act_internal_net: 
            del element['originId']
            del element['siteName']
            del element['createdAt']
            del element['modifiedAt']
            del element['siteId']

        #Fazer o Load do CSV de Internal Networks para checar
        checkCSV = load_csvInternalNet()
        successinternalNetworks = ""
        if checkCSV == "NotCSV":
            messagebox.showinfo("CSV missing", "Por favor, selecione um arquivo CSV antes de enviar", parent=internalnetWindow)
        else:
            # Abrir o CSV se existe
            f = open(internalNetCSV, 'r',encoding='utf-8-sig')  

            # Adicionar as colunas no output do CSV para ficar igual JSON pra post.
            reader = csv.DictReader( f, fieldnames = ("name","ipAddress","prefixLength"))  

            
            #Odernar o Csv para nao ter problemas futuros no umbrela  
            sorted_csv = sorted(reader, key=lambda row: (row['name']))
            
            # Fazer o Parse de CSV para JSON  
            dump_new_internalnet = json.dumps( [ row for row in sorted_csv ])  
            new_internalnet = json.loads(dump_new_internalnet)
            
            count = 0
            for net in new_internalnet:
                check = checkValidIpNetwork(net['ipAddress'] + "/" + net['prefixLength'], net['name'])
                if check == False:
                    count+=1
                else:
                    pass

            if count > 0:
                messagebox.showerror("Ip's inválidos", "Verifique os Ip's no arquivo wrongips.txt que foi gerado", parent=internalnetWindow)
            else:
            
                # Remover duplicados exatos do csv e criar nova lista adionando somente o que não é duplicado
                lista_removido_duplicado = []
                for item in removeduplicate(new_internalnet):
                    lista_removido_duplicado.append(item)
                
                #Remover nomes iguais dentro da lista de removido_duplicado, pois se tem mais de um nome igual já no csv, mantem o primeiro e remove o resto
                lista_final_new = list()
                items_set = set()    
                for js in lista_removido_duplicado:
                    # só adiciona items nao vistos (referenciando to 'nome' como key)
                    if not js['name'] in items_set:
                        # marcar como seen
                        items_set.add(js['name'])         
                        # add to results
                        lista_final_new.append(js)

                #Remover Ip/prefix iguais dentro da lista de removido_duplicado, pois se tem mais de um um ip/prefix igual já no csv, mantem o primeiro e remove o resto
                lista_final = list()
                items_set_ip = set()
                for ip in lista_final_new:
                    # só adiciona items nao vistos (referenciando to 'ipddress/prefix' como key)
                    ipnet = ip['ipAddress'] + "/" + str(ip['prefixLength'])
                    if not ipnet in items_set_ip:
                        # marcar como seen
                        items_set_ip.add(ipnet)          
                        # adciona a lista final
                        lista_final.append(ip)

                #Comparar o nome e ippadress que tem no CSV com o que já tem no Umbrella, e cadastrar só os que nao tem! 
                #As comparações anteriores foram todas para o arquivos do CSV, ou seja, localmente
                for k in range(len(act_internal_net)):
                    for i in range(len(lista_final)):
                        ipatual = act_internal_net[k]['ipAddress'] + "/" + str(act_internal_net[k]['prefixLength'])
                        ipnovo =  lista_final[i]['ipAddress'] + "/" + str(lista_final[i]['prefixLength'])
                        if (act_internal_net[k]["name"] == lista_final[i]['name'] or ipatual == ipnovo):
                            lista_final.pop(i)              
                            break   
                
                #Se a lista retornar vazia não cadastrar nada
                if not lista_final:
                    messagebox.showinfo("CSV já cadastrado", "Nada no CSV:" + internalNetCSV + " para cadastrar!! Provalemente o que tem no CSV, já está cadastrado no Umbrella!!!", parent=internalnetWindow)
                else:
                    for cadastrar in lista_final:
                        #Adiciona o siteID criado ao final da lista Json que vai mandar o POST
                        cadastrar['siteId'] = int(siteId)
                        post_internalnetworks_request('/organizations/{}/internalnetworks'.format(org_id), json.dumps(cadastrar))
                        successinternalNetworks += "Intenal Network: " + cadastrar['name'] + ", Ip/Prefix: " + cadastrar['ipAddress'] + "/" + cadastrar['prefixLength']  + "\n"

                    if code_access_token_net == 200:
                        now = datetime.now()
                        # dd/mm/YY H:M:S
                        dt_string = now.strftime("%d/%m/%Y %H:%M:%S")
                        if not os.path.isfile('registred_internalNetworks.log'):
                            f = open("registred_internalNetworks.log", "x")
                        f.close()
                        f = open("registred_internalNetworks.log", "a")
                        f.write("--------------------------------------")
                        f.write("\n")
                        f.write(str(dt_string))
                        f.write("\n")
                        f.write(successinternalNetworks)
                        f.close()
                        messagebox.showinfo("Internal Networks cadastradas com sucesso", "Internal Networks cadastradas com sucesso, arquivo log registred_internalNetworks.log gerado", parent=internalnetWindow)
                    elif code_access_token_net == 401 or code_access_token_net == 403:
                        messagebox.showinfo("Não autorizado ou inválido", "Verifique o arquivo de configuração", parent=internalnetWindow)

############################# Janela Internal Domains #############################
def openMenuInternalDomains():   
    # Variavel global poist tem uso em outras funções
    global internaldomainWindow
    # Criar a Janela via Toplevel e setar parametros iniciais
    internaldomainWindow = Toplevel(root) 
    internaldomainWindow.title("Umbrella Internal Domains Register") 
    internaldomainWindow.wm_iconbitmap('favicon_cisco.ico')
    internaldomainWindow.configure(bg='#0ea3da')
    internaldomainWindow.minsize(400,200)
    center(internaldomainWindow)
    internaldomainWindow.resizable(0,0)
    

    label = Label(internaldomainWindow,text='Cadastrar Internal Domains',font='Calibri 15 bold', bg='#0ea3da')
    label.grid(column=1,row=0)

    label = Label(internaldomainWindow,text='Ecolher CSV', font='Calibri 13 bold', bg='#0ea3da')
    label.grid(column=0,row=2,padx=4, pady=11, sticky='W')

    botao_csv = Button(internaldomainWindow, text = "Explorar Arquivos", width=20, height=1, command= lambda: browseInternalDomains(False))
    botao_csv.place(relx=.26, rely=.22)

    botao_enviar = Button(internaldomainWindow, text = "Enviar", width=20, height=1,borderwidth = '2', command=CadastrarInternalDomains)
    botao_enviar.place(relx=.26, rely=.40)

    internaldomainWindow.protocol("WM_DELETE_WINDOW", on_closingDomain)


############################# Função para pegar o CSV de Internal Domains #############################
def load_csvInternalDomains():
    # Lista para atribuir os dominios do CSV
    csv_domains = []
    try:
        # Tentando abrir o arquivo especificado
        with open(internaldomainCSV) as csv_file_domain:
            csv_reader_domain = csv.reader(csv_file_domain)

            # Adicionar cada dominio na lista de csv_domains
            for domain in csv_reader_domain:
                csv_domains.append(domain[0])
            return csv_domains
    except:
        return "NotCSV"

############################# Ação do botão para cadastrar Internal Domains via CSV #############################
def CadastrarInternalDomains():
    checkCSV = load_csvInternalDomains()
    successinternalDomains = ""
    internaldomainWindow.focus_set()
    if checkCSV == "NotCSV":
        messagebox.showinfo("CSV missing", "Por favor, selecione um arquivo CSV antes de enviar", parent=internaldomainWindow)
    else:
        new_internaldomains = []
        new_internaldomains += load_csvInternalDomains()

        # fazer o get das internal netwokrs para comparar com o vsv
        r_get_internaldomain = get_internaldomains_request('/organizations/{}/internaldomains'.format(org_id))     
        lista_exist_umbrella = []

        #Adicionar do Umbrella Internal Domains a uma lista
        for internadomail in r_get_internaldomain:
            lista_exist_umbrella.append(internadomail['domain'])

        #Remover duplicados no CSV
        new_internaldomains = list(dict.fromkeys(new_internaldomains))
        
        # Remover da lista o que já esta cadastrado no Umbrella
        new_internaldomains = list(set(new_internaldomains) - set(lista_exist_umbrella))
        
        #Se a lista retornar vazia não cadastrar nada
        if not new_internaldomains:
            messagebox.showinfo("CSV já cadastrado", "Nada no CSV:" + internaldomainCSV + " para cadastrar!! Provalemente o que tem no CSV, já está cadastrado no Umbrella!!!", parent=internaldomainWindow)
            #print("Nada no CSV:" + internaldomainCSV + " para cadastrar!! Provalemente o que tem no CSV, já está cadastrado no Umbrella!!!")
        else:   
            for cadastrar in new_internaldomains:        
                post_internaldomains_request('/organizations/{}/internaldomains'.format(org_id), cadastrar)
                successinternalDomains += cadastrar + "\n"
        
        if code_access_token_domains == 200:
            if not os.path.isfile('registred_domains.log'):
                f = open("registred_domains.log", "x")
            f.close()
            now = datetime.now()
            dt_string = now.strftime("%d/%m/%Y %H:%M:%S")
            messagebox.showinfo("Internal Domains cadastradas com sucesso", "Internal Networks Domains com sucesso, arquivo log registred_domains.log gerado", parent=internaldomainWindow)
            f = open("registred_domains.log", "a")
            f.write("--------------------------------------")
            f.write("\n")
            f.write(str(dt_string))
            f.write("\n")
            f.write(successinternalDomains)
            f.close()
        elif code_access_token_domains == 401 or code_access_token_domains == 403:
                        messagebox.showinfo("Não autorizado ou inválido", "Verifique o arquivo de configuração", parent=internalnetWindow)

############################# Janela Internal Domains #############################
def openMenuSitesCSV():   
    # Variavel global poist tem uso em outras funções
    global SitesCSVWindow
    # Criar a Janela via Toplevel e setar parametros iniciais
    SitesCSVWindow = Toplevel(root) 
    SitesCSVWindow.title("Umbrella Internal Domains Register") 
    SitesCSVWindow.wm_iconbitmap('favicon_cisco.ico')
    SitesCSVWindow.configure(bg='#0ea3da')
    SitesCSVWindow.minsize(400,200)
    center(SitesCSVWindow)
    SitesCSVWindow.resizable(0,0)
    

    label = Label(SitesCSVWindow,text='Cadastrar Sites',font='Calibri 15 bold', bg='#0ea3da')
    label.grid(column=1,row=0)

    label = Label(SitesCSVWindow,text='Ecolher CSV', font='Calibri 13 bold', bg='#0ea3da')
    label.grid(column=0,row=2,padx=4, pady=11, sticky='W')

    botao_csv = Button(SitesCSVWindow, text = "Explorar Arquivos", width=20, height=1, command= lambda: browseSitesCSV(False))
    botao_csv.place(relx=.26, rely=.22)

    botao_enviar = Button(SitesCSVWindow, text = "Enviar", width=20, height=1,borderwidth = '2', command=CadastrarSitesCSV)
    botao_enviar.place(relx=.26, rely=.40)

    SitesCSVWindow.protocol("WM_DELETE_WINDOW", on_closingSitesCSV)

############################# Função para pegar o CSV de Sites #############################
def load_csvSites():
    # Lista para atribuir os dominios do CSV
    csv_sites = []
    try:
        # Tentando abrir o arquivo especificado
        with open(SitesCSV) as csv_file_sites:
            csv_reader_site = csv.reader(csv_file_sites)

            # Adicionar cada dominio na lista de csv_domains
            for site in csv_reader_site:
                csv_sites.append(site[0])
            return csv_sites
    except:
        return "NotCSV"

############################# Ação do botão para cadastrar Sites via CSV  #############################
def CadastrarSitesCSV():
    checkCSV = load_csvSites()
    successSites = ""
    SitesCSVWindow.focus_set()
    if checkCSV == "NotCSV":
        messagebox.showinfo("CSV missing", "Por favor, selecione um arquivo CSV antes de enviar", parent=SitesCSVWindow)
    else:
        new_sites = []
        new_sites += load_csvSites()

        # fazer o get das internal netwokrs para comparar com o vsv
        r_get_sites = get_sites_request('/organizations/{}/sites'.format(org_id))     
        listaSites_exist_umbrella = []

        #Adicionar do Umbrella Internal Domains a uma lista
        for site in r_get_sites:
            listaSites_exist_umbrella.append(site['name'])

        #Remover duplicados no CSV
        new_sites = list(dict.fromkeys(new_sites))
        
        # Remover da lista o que já esta cadastrado no Umbrella
        new_sites = list(set(new_sites) - set(listaSites_exist_umbrella))
        
        #Se a lista retornar vazia não cadastrar nada
        if not new_sites:
            messagebox.showinfo("CSV já cadastrado", "Nada no CSV:" + SitesCSV + " para cadastrar!! Provalemente o que tem no CSV, já está cadastrado no Umbrella!!!", parent=SitesCSVWindow)
            #print("Nada no CSV:" + internaldomainCSV + " para cadastrar!! Provalemente o que tem no CSV, já está cadastrado no Umbrella!!!")
        else:   
            for cadastrarSites in new_sites:        
                post_site_request('/organizations/{}/sites'.format(org_id), cadastrarSites)
                successSites += cadastrarSites + "\n"
        
        if code_access_token_site == 200:
            if not os.path.isfile('registred_sites.log'):
                f = open("registred_sites.log", "x")
            f.close()
            now = datetime.now()
            dt_string = now.strftime("%d/%m/%Y %H:%M:%S")
            messagebox.showinfo("Internal Domains cadastradas com sucesso", "Internal Networks Domains com sucesso, arquivo log registred_domains.log gerado", parent=internaldomainWindow)
            f = open("registred_sites.log", "a")
            f.write("--------------------------------------")
            f.write("\n")
            f.write(str(dt_string))
            f.write("\n")
            f.write(successSites)
            f.close()
        elif code_access_token_site == 401 or code_access_token_site == 403:
            messagebox.showinfo("Não autorizado ou inválido", "Verifique o arquivo de configuração", parent=internalnetWindow)

        

############################# Função para centralizar as Windows #############################
def center(win):
    win.update_idletasks()
    width = win.winfo_width()
    frm_width = win.winfo_rootx() - win.winfo_x()
    win_width = width + 2 * frm_width
    height = win.winfo_height()
    titlebar_height = win.winfo_rooty() - win.winfo_y()
    win_height = height + titlebar_height + frm_width
    x = win.winfo_screenwidth() // 2 - win_width // 2
    y = win.winfo_screenheight() // 2 - win_height // 2
    win.geometry('{}x{}+{}+{}'.format(width, height, x, y))
    win.deiconify()


############################# Função para definir imagens de background de Windows #############################
def backgroundImage(win):
    IMAGE_PATH = 'umbrella.jpg'
    WIDTH, HEIGTH = win.winfo_width(), win.winfo_height()

    canvas = Canvas(win, width=WIDTH, height=HEIGTH)
    canvas.pack()

    img = ImageTk.PhotoImage(Image.open(IMAGE_PATH).resize((WIDTH, HEIGTH), Image.ANTIALIAS))
    canvas.background = img  # Keep a reference in case this code is put in a function.
    bg = canvas.create_image(0, 0, anchor=NW, image=img)


############################# Menu Principal #############################
def menu():
    global MenuPrincipal
    MenuPrincipal = Toplevel(root)
    menubar = Menu(MenuPrincipal)
    MenuPrincipal.config(menu=menubar)
    MenuPrincipal.wm_iconbitmap('favicon_cisco.ico')
    MenuPrincipal.title('Cisco Umbrella API Calls')
    MenuPrincipal.minsize(800,500)
    MenuPrincipal.resizable(0,0)
    center(MenuPrincipal)
    backgroundImage(MenuPrincipal)

    filemenu = Menu(menubar, tearoff=0)
    filemenu.add_separator()
    filemenu2 = Menu(menubar, tearoff=0)
    filemenu2.add_separator()
    filemenu3 = Menu(menubar, tearoff=0)
    filemenu3.add_separator()
    filemenu4 = Menu(menubar, tearoff=0)
    filemenu4.add_separator()
    filemenu5 = Menu(menubar, tearoff=0)
    filemenu5.add_separator()


    menubar.add_cascade(label='Sites and Active Directory', menu=filemenu)
    menubar.add_cascade(label='Internal Networks', menu=filemenu2)
    menubar.add_cascade(label='Domain Management', menu=filemenu3)
    menubar.add_cascade(label='Config File', menu=filemenu4)
    menubar.add_cascade(label='Sair', menu=filemenu5)

    #Menu Cadastrar Sites
    filemenu.add_command(label='Castrar Sites via arquivo CSV', command=openMenuSitesCSV)
    filemenu.add_command(label='Cadastrar Site manualmente', command=openMenuSiteManual)
    #Menu Cadastrar Internal Networks
    filemenu2.add_command(label='Cadastrar Internal Networks via arquivo CSV', command=openMenuInternalNetworks)
    #Menu Cadastrar Internal Domains
    filemenu3.add_command(label='Cadastrar Internal Domains via arquivo CSV', command=openMenuInternalDomains)
    #Menu Sair
    filemenu4.add_command(label='Configurar parâmetros de configuração do Umbrella', command=openMenuConfigurationFile)
    #Menu Sair
    filemenu5.add_command(label='Sair', command=Quit)

def VerificaEmail(email):
    r_users = get_users_request('/organizations/{}/users'.format(org_id)) 
    for user in r_users:
        if email == user['email']:
            print(user['email'])
            if user['role'] == "Full Admin":
                menu()
                root.withdraw()    
            else:
                print("ok1")
            break       
        else:
            print("ok2")
            
      
 
root = Tk()
root.title("Acesso Umbrella API Calls") 
root.wm_iconbitmap('favicon_cisco.ico')
root.minsize(400,200)
center(root)
root.resizable(0,0)
label = Label(root,text='Acesso',font='Calibri 14 bold')
label.grid(column=1,row=0,pady=6)

label = Label(root,text='Admin email: ', font='Calibri 10 bold')
label.grid(column=0,row=1,padx=8, sticky='W')

emailTxt = Text(root, width=25, height=1)
emailTxt.grid(column=1,row=1,pady=2)
emailTxt.focus_set()

accessoBtn = Button(root, text = "Acesso", width=25, command = lambda: VerificaEmail(emailTxt.get("1.0","end-1c")))
accessoBtn.grid(column= 1, row = 4,pady=3)

try:
    root.mainloop()
except (KeyboardInterrupt, SystemExit):
    sys.stdout.flush()
    pass





if __name__ == "__main__":
    #Varáveis que devem começar vazias quando rodar o script
    internaldomainCSV = ""
    SitesCSV = ""
    internalNetCSV = ""